package com.music.player.auth.rest;

import com.music.player.auth.api.dto.AuthInfo;
import com.music.player.auth.biz.UserBiz;
import com.music.player.auth.dto.UserGetCodeDto;
import com.music.player.auth.dto.UserLoginDto;
import com.music.player.auth.dto.UserRegisterDto;
import com.music.player.framework.common.base.R;
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
@RequestMapping("user")
public class UserCtrl {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserBiz userBiz;

    @PostMapping("login")
    public R<AuthInfo> login(UserLoginDto userLoginDto) {
        AuthInfo authInfo = userBiz.login(userLoginDto);
        return R.ok(authInfo);
    }

    /**
     * 用户注册
     * @param userRegisterDto -
     * @return -
     */
    @PostMapping("register")
    public R<Boolean> regitsrer(UserRegisterDto userRegisterDto) {
        userBiz.register(userRegisterDto);
        return R.success();
    }

    @PostMapping("getCode")
    public R<Boolean> getCode(UserGetCodeDto userGetCodeDto) {
        return R.success();
    }

    @GetMapping("userInfo")
    public R<Boolean> userInfo() {
        return R.success();
    }
}
