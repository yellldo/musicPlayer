package com.music.player.auth.rest;

import com.music.player.auth.api.dto.UserGetCodeDto;
import com.music.player.auth.api.dto.UserLoginDto;
import com.music.player.auth.api.dto.UserRegisterDto;
import com.music.player.auth.api.service.UserServiceFeign;
import com.music.player.auth.biz.UserBiz;
import com.music.player.common.domain.R;
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
    public R login(UserLoginDto userLoginDto) {
        userBiz.login(userLoginDto);
        return null;
    }

    @Override
    public R regitsrer(UserRegisterDto userRegisterDto) {
        userBiz.register(userRegisterDto);
        return R.ok();
    }

    @Override
    public R getCode(UserGetCodeDto userGetCodeDto) {
        return null;
    }
}
