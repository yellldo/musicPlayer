package com.music.player.auth.rest;

import com.music.player.auth.api.dto.AuthInfo;
import com.music.player.auth.biz.UserBiz;
import com.music.player.auth.dto.UserGetCodeDto;
import com.music.player.auth.dto.UserLoginDto;
import com.music.player.auth.dto.UserRegisterDto;
import com.music.player.framework.common.base.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * ClassName : UserCtrl<br>
 * Description : UserCtrl<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping("user")
public class UserCtrl {

    @Autowired
    private UserBiz userBiz;

    @ApiOperation(value = "用户登录")
    @PostMapping("login")
    public R<AuthInfo> login(@RequestBody @Valid UserLoginDto userLoginDto) {
        AuthInfo authInfo = userBiz.login(userLoginDto);
        return R.ok(authInfo);
    }

    /**
     * 用户注册
     *
     * @param userRegisterDto -
     * @return -
     */
    @ApiOperation("用户注册")
    @PostMapping("register")
    public R regitsrer(@RequestBody @Valid UserRegisterDto userRegisterDto) {
        userBiz.register(userRegisterDto);
        return R.success();
    }

    @PostMapping("getCode")
    public R getCode(@RequestBody UserGetCodeDto userGetCodeDto) {
        return R.success();
    }

    @ApiOperation("获取用户信息")
    @GetMapping("userInfo")
    public R userInfo() {
        return R.success();
    }
}
