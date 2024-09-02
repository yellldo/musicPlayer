package com.music.player.auth.rest;

import com.music.player.auth.biz.SysUserBiz;
import com.music.player.auth.dto.QuerySysUserListDto;
import com.music.player.auth.dto.SysUserRegisterDto;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName : SysUserCtrl<br>
 * Description : SysUserCtrl<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@RestController
@RequestMapping("sysUser")
public class SysUserCtrl {

    @Autowired
    private SysUserBiz sysUserBiz;

    @PostMapping("register")
    public R register(@RequestBody SysUserRegisterDto sysUserRegisterDto) {
        sysUserBiz.register(sysUserRegisterDto);
        return R.ok();
    }


    @GetMapping("querySysUserList")
    public R querySysUserList(QuerySysUserListDto querySysUserListDto) {
        return R.ok(sysUserBiz.querySysUserList(querySysUserListDto));
    }

}
