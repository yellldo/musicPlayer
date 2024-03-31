package com.music.player.auth.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.music.player.auth.api.dto.AuthInfo;
import com.music.player.auth.api.dto.JwtUser;
import com.music.player.auth.api.dto.UserLoginDto;
import com.music.player.auth.api.dto.UserRegisterDto;
import com.music.player.auth.config.JwtConfig;
import com.music.player.auth.convert.UserConvert;
import com.music.player.auth.entity.UserInfo;
import com.music.player.auth.service.UserInfoService;
import com.music.player.auth.utils.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.music.player.auth.api.enums.ErrorCodeConstants.*;
import static com.music.player.framework.common.exceptions.utils.ServiceExceptionUtil.exception;


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
    private RedisTemplate redisTemplate;
    @Autowired
    private JwtConfig jwtConfig;

    /**
     * 登录并生成token
     */
    public AuthInfo login(UserLoginDto userLoginDto) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        if ("1".equals(userLoginDto.getLoginType())) {
            queryWrapper.eq(UserInfo::getPhone, userLoginDto.getLoginName());
        } else {
            queryWrapper.eq(UserInfo::getEmail, userLoginDto.getLoginName());
        }
        UserInfo userInfo = userInfoService.getOne(queryWrapper);
        if (userInfo == null) {
            throw exception(USER_NOT_EXISTS);
        }
        if (!userLoginDto.getPassword().equals(userInfo.getPassword())) {
            throw exception(PASSWORD_NOT_MATCH);
        }
        JwtUser jwtUser = UserConvert.INSTANT.jwtUser(userInfo);
        String token = jwtTokenUtil.generateToken(jwtUser);
        redisTemplate.opsForValue().set(jwtConfig.getOnlineKey() + token, jwtUser, jwtConfig.getExpiration(), TimeUnit.MICROSECONDS);
        return new AuthInfo(token, jwtUser);
    }


    public void register(UserRegisterDto userRegisterDto) {
        if (StringUtils.isNotBlank(userRegisterDto.getPhone())) {
            LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(UserInfo::getPhone, userRegisterDto.getPhone());
            long count = userInfoService.count(queryWrapper);
            if (count > 0) {
                throw exception(PHONE_NOT_EXISTS);
            }
        }
        if (StringUtils.isNotBlank(userRegisterDto.getEmail())) {
            LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(UserInfo::getEmail, userRegisterDto.getEmail());
            long count = userInfoService.count(queryWrapper);
            if (count > 0) {
                throw exception(EMAIL_NOT_EXISTS);
            }
        }
        UserInfo userInfo = UserConvert.INSTANT.register(userRegisterDto);
        userInfoService.save(userInfo);
    }


}
