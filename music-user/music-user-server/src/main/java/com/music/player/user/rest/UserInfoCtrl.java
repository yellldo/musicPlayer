package com.music.player.user.rest;

import cn.dev33.satoken.annotation.SaIgnore;
import com.music.player.framework.common.base.R;
import com.music.player.user.biz.UserInfoBiz;
import com.music.player.user.dto.CreateUserInfoDto;
import com.music.player.user.dto.UpdateUserInfoDto;
import com.music.player.user.dto.UserInfoPageDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName : UserInfoCtrl<br>
 * Description : UserInfoCtrl<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoCtrl {


    @Autowired
    private UserInfoBiz userInfoBiz;


    @PostMapping("create")
    public R create(@Valid @RequestBody CreateUserInfoDto createUserInfoDto) {
        userInfoBiz.create(createUserInfoDto);
        return R.ok();
    }

    @GetMapping("page")
    public R page(UserInfoPageDto userInfoPageDto) {
        return userInfoBiz.page(userInfoPageDto);
    }


    @PostMapping("update")
    public R update(@Valid @RequestBody UpdateUserInfoDto updateUserInfoDto) {
        userInfoBiz.update(updateUserInfoDto);
        return R.ok();
    }

}
