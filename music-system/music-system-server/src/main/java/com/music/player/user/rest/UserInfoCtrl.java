package com.music.player.user.rest;

import com.music.player.framework.common.base.R;
import com.music.player.framework.log.annotation.HttpRequestLog;
import com.music.player.user.biz.UserInfoBiz;
import com.music.player.user.dto.UpdateUserInfoDto;
import com.music.player.user.dto.UserInfoIdDto;
import com.music.player.user.dto.UserInfoPageDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName : UserInfoCtrl<br>
 * Description : UserInfoCtrl<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoCtrl {

    @Autowired
    private UserInfoBiz userInfoBiz;

    @HttpRequestLog(logRemark = "门户用户查询（分页）")
    @GetMapping("page")
    public R page(UserInfoPageDto userInfoPageDto) {
        return R.ok(userInfoBiz.page(userInfoPageDto));
    }

    @PostMapping("update")
    public R<?> update(@Valid @RequestBody UpdateUserInfoDto updateUserInfoDto) {
        userInfoBiz.update(updateUserInfoDto);
        return R.ok();
    }

    @PostMapping("delete")
    public R<?> delete(@Valid @RequestBody UserInfoIdDto userInfoIdDto) {
        userInfoBiz.delete(userInfoIdDto);
        return R.ok();
    }


}
