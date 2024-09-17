package com.music.player.auth.rest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.music.player.auth.biz.SysRoleBiz;
import com.music.player.auth.biz.SysRoleMenuBiz;
import com.music.player.auth.dto.ModifyRoleDto;
import com.music.player.auth.dto.QueryRoleListDto;
import com.music.player.auth.dto.RoleRelationMenuDto;
import com.music.player.auth.dto.SaveRoleDto;
import com.music.player.auth.service.SysRoleService;
import com.music.player.auth.vo.SysRoleVo;
import com.music.player.framework.common.base.R;
import com.music.player.web.annotation.LogRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import javax.validation.Valid;


/**
 * ClassName : SysRoleCtrl<br>
 * Description : SysRoleCtrl<br>
 *
 * @author : sj
 * @date : 2024/9/11
 */
@Api(tags = "后台角色")
@RestController
@RequestMapping("sysRole")
public class SysRoleCtrl {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleBiz sysRoleBiz;
    @Autowired
    private SysRoleMenuBiz sysRoleMenuBiz;

    @LogRecord(value = "查询角色")
    @GetMapping("queryRoleList")
    public R<IPage<SysRoleVo>> queryRoleList(QueryRoleListDto queryRoleListDto) {
        return R.ok(sysRoleService.queryRoleList(queryRoleListDto));
    }

    @LogRecord(value = "新增角色")
    @PostMapping("saveRole")
    public R saveRole(@RequestBody @Valid SaveRoleDto saveRoleDto) {
        sysRoleBiz.saveRole(saveRoleDto);
        return R.ok();
    }

    @LogRecord(value = "修改角色信息")
    @PostMapping("modifyRole")
    public R modifyRole(@RequestBody @Valid ModifyRoleDto modifyRoleDto) {
        sysRoleBiz.modifyRole(modifyRoleDto);
        return R.ok();
    }

    @ApiOperation("角色关联菜单")
    @LogRecord("角色关联菜单")
    @PostMapping("relation")
    public R relation(@RequestBody @Valid RoleRelationMenuDto roleRelationMenuDto) {
        sysRoleMenuBiz.relation(roleRelationMenuDto);
        return R.ok();
    }


}
