package com.music.player.auth.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.music.player.auth.api.dto.AuthInfo;
import com.music.player.auth.api.dto.JwtUser;
import com.music.player.auth.api.enums.ErrorCodeConstants;
import com.music.player.auth.api.service.user.dto.GetUserInfoDto;
import com.music.player.auth.api.service.user.vo.UserInfoVo;
import com.music.player.auth.config.JwtConfig;
import com.music.player.auth.constants.AuthConstants;
import com.music.player.auth.constants.AuthRedisConstant;
import com.music.player.auth.convert.UserConvert;
import com.music.player.auth.dto.UserLoginDto;
import com.music.player.auth.dto.UserRegisterDto;
import com.music.player.auth.entity.UserInfo;
import com.music.player.auth.service.UserInfoService;
import com.music.player.auth.utils.BCryptUtil;
import com.music.player.auth.utils.JwtTokenUtil;
import com.music.player.framework.cache.service.CacheService;
import com.music.player.framework.common.support.BizException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;


/**
 * ClassName : UserBiz<br>
 * Description : UserBiz<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@Service
public class UserBiz {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private JwtConfig jwtConfig;

    /**
     * login and generate token.
     */
    public AuthInfo login(UserLoginDto userLoginDto) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        if (AuthConstants.LOGIN_TYPE_PHONE.equals(userLoginDto.getLoginType())) {
            queryWrapper.eq(UserInfo::getPhone, userLoginDto.getLoginName());
        } else {
            queryWrapper.eq(UserInfo::getEmail, userLoginDto.getLoginName());
        }
        UserInfo userInfo = userInfoService.getOne(queryWrapper);
        if (userInfo == null) {
            throw new BizException(ErrorCodeConstants.USER_NOT_EXISTS);
        }
        if (!BCryptUtil.checkPassword(userLoginDto.getPassword(), userInfo.getPassword())) {
            throw new BizException(ErrorCodeConstants.PASSWORD_NOT_MATCH);
        }

        // todo get user info

        JwtUser jwtUser = UserConvert.INSTANT.jwtUser(userInfo);
        String token = jwtTokenUtil.generateToken(jwtUser);
        cacheService.set(jwtConfig.getOnlineKey() + token, jwtUser, Duration.ofHours(jwtConfig.getExpiration()));
        return new AuthInfo(token, jwtUser);
    }

    /**
     * register.
     *
     * @param userRegisterDto
     */
    public void register(UserRegisterDto userRegisterDto) {
        if (StringUtils.isNotBlank(userRegisterDto.getPhone())) {
            LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(UserInfo::getPhone, userRegisterDto.getPhone());
            long count = userInfoService.count(queryWrapper);
            if (count > 0) {
                throw new BizException(ErrorCodeConstants.PHONE_EXISTS);
            }
            userRegisterDto.setLoginType(AuthConstants.LOGIN_TYPE_PHONE);
        }
        if (StringUtils.isNotBlank(userRegisterDto.getEmail())) {
            LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(UserInfo::getEmail, userRegisterDto.getEmail());
            long count = userInfoService.count(queryWrapper);
            if (count > 0) {
                throw new BizException(ErrorCodeConstants.EMAIL_EXISTS);
            }
            userRegisterDto.setLoginType(AuthConstants.LOGIN_TYPE_EMAIL);
        }
        userRegisterDto.setPassword(BCryptUtil.hashPassword(userRegisterDto.getPassword()));
        UserInfo userInfo = UserConvert.INSTANT.register(userRegisterDto);
        userInfoService.save(userInfo);
    }

    /**
     * get user info.
     *
     * @param getUserInfoDto
     * @return
     */
    public UserInfoVo getUserInfo(GetUserInfoDto getUserInfoDto) {
        String cacheKey = AuthRedisConstant.USER_KEY + getUserInfoDto.getUserId();
        if (cacheService.exists(cacheKey)) {
            return cacheService.get(cacheKey);
        }
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUserId, getUserInfoDto.getUserId());
        UserInfo userInfo = userInfoService.getOne(queryWrapper);
        UserInfoVo getUserInfoVo = UserConvert.INSTANT.getUserInfo(userInfo);
        cacheService.set(cacheKey, getUserInfoVo);
        return getUserInfoVo;
    }

}
