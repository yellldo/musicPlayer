package com.music.player.system.rest;


import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.R;
import com.music.player.system.biz.SysUserBiz;
import com.music.player.system.dto.*;
import com.music.player.system.vo.SysUserVo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : SysUserCtrl<br>
 * Description : SysUserCtrl<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Slf4j
@RestController
@RequestMapping("sysUser")
public class SysUserCtrl {

    @Autowired
    private SysUserBiz sysUserBiz;

    /**
     * Registered users
     */
    @PostMapping("create")
    public R<?> create(@Valid @RequestBody CreateSysUserDto createSysUserDto) {
        sysUserBiz.create(createSysUserDto);
        return R.ok();
    }

    /**
     * reset passwords
     */
    @PostMapping("resetPwd")
    public R<?> resetPwd(@Valid @RequestBody SysUserResetPwdDto sysUserResetPwdDto) {
        sysUserBiz.resetPwd(sysUserResetPwdDto);
        return R.ok();
    }

    /**
     * Change user password
     */
    @PostMapping("updatePwd")
    public R updatePwd(@Valid @RequestBody SysUserUpdatePwdDto sysUserUpdatePwdDto) {
        sysUserBiz.updatePwd(sysUserUpdatePwdDto);
        return R.ok();
    }

    /**
     * Change user status
     */
    @PostMapping("updateStatus")
    public R<?> updateStatus(@Valid @RequestBody SysUserUpdateStatusDto sysUserUpdateStatusDto) {
        sysUserBiz.updateStatus(sysUserUpdateStatusDto);
        return R.ok();
    }

    /**
     * delete user
     */
    @PostMapping("deleteUser")
    public R<?> deleteUser(@Valid @RequestBody SysUserDeleteUserDto sysUserDeleteUserDto) {
        sysUserBiz.deleteUser(sysUserDeleteUserDto);
        return R.ok();
    }

    /**
     * Pagination query
     */
    @PostMapping("page")
    public R<PageResult<SysUserVo>> page(@RequestBody SysUserPageDto sysUserPageDto) {
        return R.ok(sysUserBiz.page(sysUserPageDto));
    }

    /**
     * change user information
     */
    @PostMapping("update")
    public R<Void> update(@Valid @RequestBody SysUserUpdateDto sysUserUpdateDto) {
        sysUserBiz.update(sysUserUpdateDto);
        return R.ok();
    }

}
