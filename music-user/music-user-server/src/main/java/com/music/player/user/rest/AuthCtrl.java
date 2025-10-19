package com.music.player.user.rest;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.RandomUtil;
import com.music.player.framework.common.base.R;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.redis.domain.RedisOps;
import com.music.player.user.biz.AuthBiz;
import com.music.player.user.constants.RedisConstants;
import com.music.player.user.dto.LoginDto;
import com.music.player.user.dto.LoginGetCodeDto;
import com.music.player.user.dto.RegisterUserDto;
import com.music.player.user.enmus.ErrorCodeConstants;
import com.music.player.user.vo.LoginVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


/**
 * ClassName : AuthCtrl<br>
 * Description : AuthCtrl<br>
 *
 * @author : sj
 * @date : 10/9/25
 */
@Slf4j
@RestController
@RequestMapping("auth")
public class AuthCtrl {

    @Autowired
    private RedisOps redisOps;
    @Autowired
    private AuthBiz authBiz;

    @PostMapping("login")
    public R<LoginVo> login(@Valid @RequestBody LoginDto loginDto, HttpServletRequest request) {
        String key = RedisConstants.LOGIN_PHONE_CODE + loginDto.getPhone();
        LoginVo loginVo;
        try {
            Integer code = redisOps.get(key, false);
            if (!Objects.nonNull(code)) {
                throw new BusinessException(ErrorCodeConstants.PHONE_CODE_EXPIRED);
            }
            if (!code.equals(loginDto.getCode())) {
                throw new BusinessException(ErrorCodeConstants.PHONE_CODE_NOT_MATCH);
            }
            SaTokenInfo tokenInfo = authBiz.login(request, loginDto);

            loginVo = new LoginVo()
                    .setToken(tokenInfo.getTokenValue())
                    .setTokenTimeout(tokenInfo.getTokenTimeout());

        } catch (Exception e) {
            log.error("登陆失败", e);
            throw e;
        } finally {
            redisOps.del(key);
        }
        return R.ok(loginVo);
    }

    @SaIgnore
    @PostMapping("register")
    public R<?> register(@RequestBody RegisterUserDto registerUserDto) {
        authBiz.register(registerUserDto);
        return R.ok();
    }

    @SaCheckLogin
    @PostMapping("info")
    public R info(HttpServletRequest request) {
        return R.ok();
    }

    @SaIgnore
    @PostMapping("getCode")
    public R<?> getCode(@Valid @RequestBody LoginGetCodeDto loginGetCodeDto) {
        String key;
        if ("1".equals(loginGetCodeDto.getType())) {
            key = RedisConstants.LOGIN_PHONE_CODE + loginGetCodeDto.getPhone();
        } else {
            key = RedisConstants.REGISTER_PHONE_CODE + loginGetCodeDto.getPhone();
        }
        if (redisOps.exists(key)) {
            throw new BusinessException(ErrorCodeConstants.PHONE_CODE_EXISTS);
        }
        int value = RandomUtil.randomInt(100000, 999999);
        redisOps.setEx(key, value, 60L, true);
        return R.ok(value);
    }

    @PostMapping("logout")
    public R<?> logout(HttpServletRequest request) {
        StpUtil.logout();
        return R.ok();
    }
}
