package com.music.player.system.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.SortingField;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.music.player.system.convert.SysRoleConvert;
import com.music.player.system.dto.SysRoleCreateDto;
import com.music.player.system.dto.SysRolePageDto;
import com.music.player.system.enmus.ErrorCodeConstants;
import com.music.player.system.entity.SysRole;
import com.music.player.system.service.SysRoleService;
import com.music.player.system.vo.SysRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysRoleBiz<br>
 * Description : SysRoleBiz<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Service
public class SysRoleBiz {

    @Autowired
    private SysRoleService sysRoleService;


    public void create(SysRoleCreateDto sysRoleCreateDto) {
        checkSysRoleByRoleName(sysRoleCreateDto.getRoleName());

        SysRole sysRole = SysRoleConvert.INSTANT.create(sysRoleCreateDto);
        sysRoleService.save(sysRole);
    }

    public PageResult<SysRoleVo> page(SysRolePageDto sysRolePageDto) {
        PageResult<SysRole> sysRolePageResult = sysRoleService.selectPage(sysRolePageDto, new LambdaQueryWrapperX<SysRole>()
                .eqIfPresent(SysRole::getRoleName, sysRolePageDto.getRoleName())
                .eqIfPresent(SysRole::getRoleStatus, sysRolePageDto.getRoleStatus())
                .eq(SysRole::getIsDelete, CommonConstants.STATUS_NOT_DEL), SortingField.ORDER_DESC);

        return SysRoleConvert.INSTANT.convertPage(sysRolePageResult);
    }


    /**
     * Check if a role exists based on the role name
     */
    private void checkSysRoleByRoleName(String roleName) {
        long count = sysRoleService.selectCount(new LambdaQueryWrapperX<SysRole>()
                .eq(SysRole::getRoleName, roleName)
                .eq(SysRole::getIsDelete, CommonConstants.STATUS_NOT_DEL));

        if (count > 0) {
            throw new BusinessException(ErrorCodeConstants.ROLE_NAME_EXISTS);
        }
    }


}
