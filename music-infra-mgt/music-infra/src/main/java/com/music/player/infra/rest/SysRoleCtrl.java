package com.music.player.infra.rest;

import com.music.player.framework.common.base.R;
import com.music.player.framework.common.constant.CommonConstants;
import com.music.player.infra.biz.SysRoleBiz;
import com.music.player.infra.dto.DeleteSysRoleDto;
import com.music.player.infra.dto.QuerySysRoleDto;
import com.music.player.infra.dto.SaveSysRoleDto;
import com.music.player.infra.dto.UpdateSysRoleDto;
import com.music.player.infra.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * ClassName : SysRoleController<br>
 * Description : SysRoleController<br>
 *
 * @author : sj
 * @date : 2024/5/24
 */
@RestController
@RequestMapping("sysRole")
public class SysRoleCtrl {

    @Autowired
    private SysRoleBiz sysRoleBiz;
    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping("saveRole")
    public R<Boolean> saveRole(@RequestBody @Valid SaveSysRoleDto saveSysRoleDto) {
        return R.ok(sysRoleBiz.saveRole(saveSysRoleDto));
    }

    @PostMapping("querySysRole")
    public R querySysRole(@RequestBody QuerySysRoleDto querySysRoleDto) {
        return R.ok(sysRoleService.querySysRole(querySysRoleDto));
    }

    @PostMapping("updateSysRole")
    public R<Boolean> updateSysRole(@RequestBody @Valid UpdateSysRoleDto updateSysRoleDto) {
        return R.ok(sysRoleBiz.updateSysRole(updateSysRoleDto));
    }

    @PostMapping("deleteSysRole")
    public R<Boolean> deleteSysRole(@RequestBody @Valid DeleteSysRoleDto deleteSysRoleDto) {
        deleteSysRoleDto.setDelFlag(CommonConstants.STATUS_DEL);
        return R.ok(sysRoleBiz.deleteSysRole(deleteSysRoleDto));
    }
}
