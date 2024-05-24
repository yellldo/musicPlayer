package com.music.player.infra.rest;

import com.music.player.framework.common.base.R;
import com.music.player.framework.common.constant.CommonConstants;
import com.music.player.infra.api.dto.DeleteSysRoleDto;
import com.music.player.infra.api.dto.QuerySysRoleDto;
import com.music.player.infra.api.dto.SaveSysRoleDto;
import com.music.player.infra.api.dto.UpdateSysRoleDto;
import com.music.player.infra.api.service.SysRoleServiceFeign;
import com.music.player.infra.biz.SysRoleBiz;
import com.music.player.infra.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : SysRoleController<br>
 * Description : SysRoleController<br>
 *
 * @author : sj
 * @date : 2024/5/24
 */
@RestController
public class SysRoleController implements SysRoleServiceFeign {

    @Autowired
    private SysRoleBiz sysRoleBiz;
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public R<Boolean> saveRole(SaveSysRoleDto saveSysRoleDto) {
        return R.ok(sysRoleBiz.saveRole(saveSysRoleDto));
    }

    @Override
    public R querySysRole(QuerySysRoleDto querySysRoleDto) {
        return R.ok(sysRoleService.querySysRole(querySysRoleDto));
    }

    @Override
    public R<Boolean> updateSysRole(UpdateSysRoleDto updateSysRoleDto) {
        return R.ok(sysRoleBiz.updateSysRole(updateSysRoleDto));
    }

    @Override
    public R<Boolean> deleteSysRole(DeleteSysRoleDto deleteSysRoleDto) {
        deleteSysRoleDto.setDelFlag(CommonConstants.STATUS_DEL);
        return R.ok(sysRoleBiz.deleteSysRole(deleteSysRoleDto));
    }
}
