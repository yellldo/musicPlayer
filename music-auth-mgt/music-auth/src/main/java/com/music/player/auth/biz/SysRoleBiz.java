package com.music.player.auth.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.music.player.auth.api.enums.ErrorCodeConstants;
import com.music.player.auth.convert.SysRoleConvert;
import com.music.player.auth.dto.ModifyRoleDto;
import com.music.player.auth.dto.SaveRoleDto;
import com.music.player.auth.entity.SysRole;
import com.music.player.auth.service.SysRoleService;
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
     * 更新角色信息
     *
     * @param modifyRoleDto
     */
    public void modifyRole(ModifyRoleDto modifyRoleDto) {
        sysRoleService.updateById(SysRoleConvert.INSTANT.modifyRole(modifyRoleDto));
    }

    /**
     * 新增角色
     *
     * @param saveRoleDto
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
