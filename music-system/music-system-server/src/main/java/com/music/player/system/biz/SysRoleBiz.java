package com.music.player.system.biz;

import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.SortingField;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.music.player.system.convert.SysRoleConvert;
import com.music.player.system.dto.*;
import com.music.player.system.enmus.ErrorCodeConstants;
import com.music.player.system.entity.SysRole;
import com.music.player.system.entity.SysRoleMenu;
import com.music.player.system.service.SysRoleMenuService;
import com.music.player.system.service.SysRoleService;
import com.music.player.system.vo.SysRoleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName : SysRoleBiz<br>
 * Description : SysRoleBiz<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@DS("system")
@Slf4j
@Service
public class SysRoleBiz {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;


    public void create(SysRoleCreateDto sysRoleCreateDto) {
        checkSysRoleByRoleName(sysRoleCreateDto.getRoleName());

        SysRole sysRole = SysRoleConvert.INSTANT.create(sysRoleCreateDto);
        sysRoleService.save(sysRole);
    }

    public PageResult<SysRoleVo> page(SysRolePageDto sysRolePageDto) {
        PageResult<SysRole> sysRolePageResult = sysRoleService.selectPage(sysRolePageDto, new LambdaQueryWrapperX<SysRole>()
                .likeIfPresent(SysRole::getRoleName, sysRolePageDto.getRoleName())
                .eqIfPresent(SysRole::getRoleStatus, sysRolePageDto.getRoleStatus())
                .eq(SysRole::getIsDelete, CommonConstants.STATUS_NOT_DEL), SortingField.ORDER_DESC);

        return SysRoleConvert.INSTANT.convertPage(sysRolePageResult);
    }

    public void deleteRole(Long roleId) {
        SysRole sysRole = new SysRole()
                .setRoleId(roleId);
        sysRole.setIsDelete(CommonConstants.STATUS_DEL);
        sysRoleService.updateById(sysRole);
    }

    public void update(SysRoleUpdateDto sysRoleUpdateDto) {

        long count = sysRoleService.selectCount(new LambdaQueryWrapperX<SysRole>()
                .eq(SysRole::getRoleName, sysRoleUpdateDto.getRoleName())
                .ne(SysRole::getRoleId, sysRoleUpdateDto.getRoleId())
                .eq(SysRole::getIsDelete, CommonConstants.STATUS_NOT_DEL));

        if (count > 0) {
            throw new BusinessException(ErrorCodeConstants.ROLE_NAME_USED);
        }

        SysRole sysRole = SysRoleConvert.INSTANT.update(sysRoleUpdateDto);
        sysRoleService.updateById(sysRole);
    }

    public void updateStatus(SysRoleUpdateStatusDto sysRoleUpdateStatusDto) {
        if (StrUtil.isBlank(sysRoleUpdateStatusDto.getRoleStatus())) {
            log.warn("roleStatus未传参，不进行操作");
            return;
        }

        checkSysRoleByRoleId(sysRoleUpdateStatusDto.getRoleId());

        SysRole sysRole = SysRoleConvert.INSTANT.updateStatus(sysRoleUpdateStatusDto);
        sysRoleService.updateById(sysRole);
    }

    public void assign(SysRoleAssignDto sysRoleAssignDto) {
        // menuIdList 为空，说明取消了所有权限
        if (sysRoleAssignDto.getMenuIdList().isEmpty()) {
            sysRoleMenuService.remove(new LambdaQueryWrapperX<SysRoleMenu>()
                    .eq(SysRoleMenu::getRoleId, sysRoleAssignDto.getRoleId()));
            return;
        }

        List<SysRoleMenu> sysRoleMenuList = new ArrayList<>();
        sysRoleAssignDto.getMenuIdList().forEach(menuId -> {
            SysRoleMenu sysRoleMenu = new SysRoleMenu()
                    .setMenuId(menuId)
                    .setRoleId(sysRoleAssignDto.getRoleId());
            sysRoleMenuList.add(sysRoleMenu);
        });

        if (!sysRoleMenuList.isEmpty()) {
            sysRoleMenuService.saveBatch(sysRoleMenuList);
        }
    }

    /**
     * Check if a role exists based on the role id
     */
    private void checkSysRoleByRoleId(Long roleId) {
        long count = sysRoleService.selectCount(new LambdaQueryWrapperX<SysRole>()
                .eq(SysRole::getRoleId, roleId)
                .eq(SysRole::getIsDelete, CommonConstants.STATUS_NOT_DEL));

        if (count > 0) {
            throw new BusinessException(ErrorCodeConstants.ROLE_NAME_EXISTS);
        }
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
