package com.music.player.infra.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.music.player.framework.common.support.BizException;
import com.music.player.infra.api.dto.DeleteSysRoleDto;
import com.music.player.infra.api.dto.SaveSysRoleDto;
import com.music.player.infra.api.dto.UpdateSysRoleDto;
import com.music.player.infra.convert.SysRoleConvert;
import com.music.player.infra.entity.SysRole;
import com.music.player.infra.service.SysRoleService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysRoleBiz<br>
 * Description : SysRoleBiz<br>
 *
 * @author : sj
 * @date : 2024/5/24
 */
@Service
public class SysRoleBiz {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 新增角色
     *
     * @param saveSysRoleDto
     * @return
     */
    public Boolean saveRole(SaveSysRoleDto saveSysRoleDto) {
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRole::getRoleName, saveSysRoleDto.getRoleName());
        long count = sysRoleService.count(queryWrapper);
        if (count > 0) {
            throw new BizException("角色名称已存在");
        }
        queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRole::getRoleCode, saveSysRoleDto.getRoleCode());
        count = sysRoleService.count(queryWrapper);
        if (count > 0) {
            throw new BizException("角色编码已存在");
        }
        sysRoleService.save(SysRoleConvert.INSTANT.saveRole(saveSysRoleDto));
        return Boolean.TRUE;
    }

    /**
     * 修改角色信息
     *
     * @param updateSysRoleDto
     * @return
     */
    public Boolean updateSysRole(UpdateSysRoleDto updateSysRoleDto) {
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRole::getRoleName, updateSysRoleDto.getRoleName());
        queryWrapper.ne(SysRole::getRoleId, updateSysRoleDto.getRoleId());
        long count = sysRoleService.count(queryWrapper);
        if (count > 0) {
            throw new BizException("角色名称已存在");
        }
        sysRoleService.updateById(SysRoleConvert.INSTANT.updateSysRole(updateSysRoleDto));
        return Boolean.TRUE;
    }


    /**
     * 删除
     *
     * @param deleteSysRoleDto
     * @return
     */
    public Boolean deleteSysRole(DeleteSysRoleDto deleteSysRoleDto) {
        sysRoleService.updateById(SysRoleConvert.INSTANT.deleteSysRole(deleteSysRoleDto));
        return Boolean.TRUE;
    }

}
