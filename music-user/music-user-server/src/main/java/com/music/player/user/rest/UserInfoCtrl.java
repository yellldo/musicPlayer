package com.music.player.user.rest;

import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.R;
import com.music.player.user.biz.UserInfoBiz;
import com.music.player.user.dto.CreateUserInfoDto;
import com.music.player.user.dto.UpdateUserInfoDto;
import com.music.player.user.dto.UserInfoPageDto;
import com.music.player.user.vo.UserInfoVo;
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

    @PostMapping("page")
    public R<PageResult<UserInfoVo>> page(@RequestBody UserInfoPageDto userInfoPageDto) {
        return R.ok(userInfoBiz.page(userInfoPageDto));
    }


    @PostMapping("update")
    public R update(@Valid @RequestBody UpdateUserInfoDto updateUserInfoDto) {
        userInfoBiz.update(updateUserInfoDto);
        return R.ok();
    }

}
