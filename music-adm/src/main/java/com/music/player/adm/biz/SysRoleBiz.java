package com.music.player.adm.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.music.player.adm.convert.SysRoleConvert;
import com.music.player.adm.dto.ModifyRoleDto;
import com.music.player.adm.dto.SaveRoleDto;
import com.music.player.adm.entity.SysRole;
import com.music.player.adm.enums.ErrorCodeConstants;
import com.music.player.adm.service.SysRoleService;
import com.music.player.framework.common.support.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysRoleBiz<br>
 * Description : SysRoleBiz<br>
 *
 * @author : sj
 * @date : 2024/9/11
 */
@Service
public class SysRoleBiz {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * Update the role information
     */
    public void modifyRole(ModifyRoleDto modifyRoleDto) {
        sysRoleService.updateById(SysRoleConvert.INSTANT.modifyRole(modifyRoleDto));
    }

    /**
     * Add a role
     */
    public void saveRole(SaveRoleDto saveRoleDto) {
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRole::getRoleName, saveRoleDto.getRoleName());
        long count = sysRoleService.count(queryWrapper);
        if (count > 0) {
            throw new BizException(ErrorCodeConstants.SYS_ROLE_EXISTS);
        }
        sysRoleService.save(SysRoleConvert.INSTANT.saveRole(saveRoleDto));
    }

}
