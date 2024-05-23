package com.music.player.auth.rest;

import com.music.player.auth.api.dto.AuthInfo;
import com.music.player.auth.api.dto.UserGetCodeDto;
import com.music.player.auth.api.dto.UserLoginDto;
import com.music.player.auth.api.dto.UserRegisterDto;
import com.music.player.auth.api.service.UserServiceFeign;
import com.music.player.auth.biz.UserBiz;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    public R<AuthInfo> login(UserLoginDto userLoginDto) {
        AuthInfo authInfo = userBiz.login(userLoginDto);
        return R.ok(authInfo);
    }

    /**
     * 用户注册
     * @param userRegisterDto -
     * @return -
     */
    @Override
    public R<Boolean> regitsrer(UserRegisterDto userRegisterDto) {
        userBiz.register(userRegisterDto);
        return R.success();
    }

    @Override
    public R<Boolean> getCode(UserGetCodeDto userGetCodeDto) {
        return R.success();
    }

    @Override
    public R<Boolean> userInfo() {
        return R.success();
    }
}
