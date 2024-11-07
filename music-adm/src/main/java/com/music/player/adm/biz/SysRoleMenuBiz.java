package com.music.player.adm.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.music.player.adm.dto.RoleRelationMenuDto;
import com.music.player.adm.entity.SysRoleMenu;
import com.music.player.adm.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

/**
 * ClassName : SysRoleMenuBiz<br>
 * Description : SysRoleMenuBiz<br>
 *
 * @author : sj
 * @date : 2024/9/17
 */
@Service
public class SysRoleMenuBiz {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private ThreadPoolTaskExecutor customAsyncTaskExecutor;

    /**
     * 角色关联菜单
     *
     * @param roleRelationMenuDto
     */
    @Transactional(rollbackFor = Exception.class)
    public void relation(RoleRelationMenuDto roleRelationMenuDto) {
        LambdaQueryWrapper<SysRoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRoleMenu::getRoleId, roleRelationMenuDto.getRoleId());
        sysRoleMenuService.remove(queryWrapper);

        roleRelationMenuDto.getMenuId().forEach(menuId -> CompletableFuture.supplyAsync(() -> {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setMenuId(menuId);
            sysRoleMenu.setRoleId(roleRelationMenuDto.getRoleId());
            sysRoleMenuService.save(sysRoleMenu);
            return null;
        }, customAsyncTaskExecutor));
    }


}
