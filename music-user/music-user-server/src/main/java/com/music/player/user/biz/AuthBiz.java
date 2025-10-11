package com.music.player.user.biz;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.net.Ipv4Util;
import cn.hutool.core.net.NetUtil;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.common.utils.IpUtils;
import com.music.player.framework.common.utils.SpringContextUtil;
import com.music.player.user.constants.UserConstants;
import com.music.player.user.convert.UserInfoConvert;
import com.music.player.user.dto.CreateUserInfoDto;
import com.music.player.user.dto.CreateUserLoginLogDto;
import com.music.player.user.dto.LoginDto;
import com.music.player.user.dto.RegisterUserDto;
import com.music.player.user.enmus.ErrorCodeConstants;
import com.music.player.user.entity.UserInfo;
import com.music.player.user.event.UserLoginLogEvent;
import com.music.player.user.vo.UserInfoVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName : AuthBiz<br>
 * Description : AuthBiz<br>
 *
 * @author : sj
 * @date : 10/10/25
 */
@Service
public class AuthBiz {

    @Autowired
    private UserInfoBiz userInfoBiz;

    /**
     * 登陆
     *
     * @param loginDto
     * @return
     */
    public SaTokenInfo login(HttpServletRequest request, LoginDto loginDto) {
        UserInfoVo userInfoVo = userInfoBiz.selectByPhone(loginDto.getPhone());

        if (BeanUtil.isEmpty(userInfoVo)) {
            throw new BusinessException(ErrorCodeConstants.USER_NOT_EXISTS);
        }

        String isDelete = userInfoVo.getIsDelete();

        if (CommonConstants.STATUS_DEL.equals(isDelete)) {
            throw new BusinessException(ErrorCodeConstants.USER_NOT_EXISTS);
        }

        String userStatus = userInfoVo.getUserStatus();

        if (!UserConstants.USER_STATUS_NORMAL.equals(userStatus)) {
            throw new BusinessException(ErrorCodeConstants.USER_STATUS_ERROR);
        }

        // 登陆
        StpUtil.login(userInfoVo.getUserId());

        // 异步记录登录记录
        CreateUserLoginLogDto createUserLoginLogDto = new CreateUserLoginLogDto()
                .setUserId(userInfoVo.getUserId())
                .setDevice(IpUtils.getClientIp(request));
        SpringContextUtil.publishEvent(new UserLoginLogEvent(createUserLoginLogDto));
        return StpUtil.getTokenInfo();
    }

    public void register(RegisterUserDto registerUserDto) {
        UserInfoVo userInfoVo = userInfoBiz.selectByPhone(registerUserDto.getPhone());
        if (!BeanUtil.isEmpty(userInfoVo)) {
            throw new BusinessException(ErrorCodeConstants.USER_EXISTS);
        }

        CreateUserInfoDto createUserInfoDto = UserInfoConvert.INSTANT.doCreate(registerUserDto);
        userInfoBiz.create(createUserInfoDto);
    }
}
