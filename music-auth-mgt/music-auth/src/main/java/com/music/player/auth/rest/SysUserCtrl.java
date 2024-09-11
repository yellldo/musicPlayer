package com.music.player.auth.rest;

import com.music.player.auth.biz.SysUserBiz;
import com.music.player.auth.dto.QuerySysUserListDto;
import com.music.player.auth.dto.SysUserLoginDto;
import com.music.player.auth.dto.SysUserRegisterDto;
import com.music.player.auth.service.SysUserService;
import com.music.player.framework.common.base.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * ClassName : SysUserCtrl<br>
 * Description : SysUserCtrl<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@Api(tags = "后台用户管理")
@RestController
@RequestMapping("sysUser")
public class SysUserCtrl {

    @Autowired
    private SysUserBiz sysUserBiz;
    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("用户注册")
    @PostMapping("register")
    public R register(@RequestBody @Valid SysUserRegisterDto sysUserRegisterDto) {
        sysUserBiz.register(sysUserRegisterDto);
        return R.ok();
    }

    @ApiOperation("查询后台用户列表")
    @GetMapping("querySysUserList")
    public R querySysUserList(QuerySysUserListDto querySysUserListDto) {
        return R.ok(sysUserService.querySysUserList(querySysUserListDto));
    }

    @ApiOperation("查询后台用户列表")
    @PostMapping("login")
    public R login(@RequestBody SysUserLoginDto sysUserLoginDto) {
        return R.ok(sysUserBiz.login(sysUserLoginDto));
    }


    @ApiOperation("更新后台用户信息")
    @PostMapping("updateSysUser")
    public R updateSysUser() {
        return R.ok();
    }
}
