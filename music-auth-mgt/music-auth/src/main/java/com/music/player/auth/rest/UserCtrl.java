package com.music.player.auth.rest;

import com.music.player.auth.api.dto.AuthInfo;
import com.music.player.auth.api.dto.UserGetCodeDto;
import com.music.player.auth.api.dto.UserLoginDto;
import com.music.player.auth.api.dto.UserRegisterDto;
import com.music.player.auth.api.service.UserServiceFeign;
import com.music.player.auth.biz.UserBiz;
import com.music.player.framework.common.domain.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : UserCtrl<br>
 * Description : UserCtrl<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@RestController
public class UserCtrl implements UserServiceFeign {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserBiz userBiz;

    @Override
    public CommonResult<AuthInfo> login(UserLoginDto userLoginDto) {
        AuthInfo authInfo = userBiz.login(userLoginDto);
        return CommonResult.success(authInfo);
    }

    @Override
    public CommonResult<Boolean> regitsrer(UserRegisterDto userRegisterDto) {
        userBiz.register(userRegisterDto);
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> getCode(UserGetCodeDto userGetCodeDto) {
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> userInfo() {
        return CommonResult.success(true);
    }
}
