package com.music.player.system.biz;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.music.player.framework.redis.domain.RedisOps;
import com.music.player.system.convert.SysMenuConvert;
import com.music.player.system.dto.SysMenuCreateDto;
import com.music.player.system.dto.SysMenuIdDto;
import com.music.player.system.dto.SysMenuPageDto;
import com.music.player.system.dto.SysMenuUpdateDto;
import com.music.player.system.entity.SysMenu;
import com.music.player.system.service.SysMenuService;
import com.music.player.system.vo.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName : SysMenuBiz<br>
 * Description : SysMenuBiz<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@DS("system")
@Service
public class SysMenuBiz {

    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private RedisOps redisOps;

    public void create(SysMenuCreateDto sysMenuCreateDto) {
        SysMenu sysMenu = SysMenuConvert.INSTANT.create(sysMenuCreateDto);
        sysMenuService.save(sysMenu);
    }

    public PageResult<SysMenuVo> page(SysMenuPageDto sysMenuPageDto) {
        PageResult<SysMenu> sysMenuPageResult = sysMenuService.selectPage(sysMenuPageDto, new LambdaQueryWrapperX<SysMenu>()
                .eqIfPresent(SysMenu::getMenuName, sysMenuPageDto.getMenuName())
                .eq(SysMenu::getIsDelete, CommonConstants.STATUS_NOT_DEL));

        return SysMenuConvert.INSTANT.convertPage(sysMenuPageResult);
    }

    public void update(SysMenuUpdateDto sysMenuUpdateDto) {
        sysMenuService.updateById(SysMenuConvert.INSTANT.update(sysMenuUpdateDto));
    }

    public void delete(SysMenuIdDto sysMenuIdDto) {
        SysMenu sysMenu = new SysMenu().setMenuId(sysMenuIdDto.getMenuId());
        sysMenu.setIsDelete(CommonConstants.STATUS_DEL);
        sysMenuService.updateById(sysMenu);
    }

    public List<SysMenuVo> tree() {
        List<SysMenu> sysMenus = sysMenuService.selectList(new LambdaQueryWrapperX<SysMenu>()
                .eq(SysMenu::getIsDelete, CommonConstants.STATUS_NOT_DEL));

        List<SysMenuVo> sysMenuVos = SysMenuConvert.INSTANT.convertList(sysMenus);

        return buildMenuTree(sysMenuVos);
    }


    public List<SysMenuVo> buildMenus(Long userId) {
        List<SysMenuVo> sysMenuVos = sysMenuService.queryMenusByUserId(userId);

        return buildMenuTree(sysMenuVos);
    }


    public List<SysMenuVo> buildMenuTree(List<SysMenuVo> menus) {
        Map<Long, SysMenuVo> menuMap = menus.stream()
                .collect(Collectors.toMap(SysMenuVo::getMenuId, menu -> menu));

        List<SysMenuVo> rootMenus = new ArrayList<>();

        for (SysMenuVo menu : menus) {
            Long parentId = menu.getParentId();
            if (parentId == null || parentId == 0L) {
                rootMenus.add(menu);
            } else {
                SysMenuVo parent = menuMap.get(parentId);
                if (parent != null) {
                    String[] parentIdList = parent.getParentIdList();
                    String[] currentParentIdList = new String[menu.getLevel()];
                    if (parentIdList != null) {
                        currentParentIdList[0] = parentIdList[0];
                        currentParentIdList[1] = String.valueOf(parent.getMenuId());
                    } else {
                        currentParentIdList[0] = String.valueOf(parent.getMenuId());
                    }
                    menu.setParentIdList(currentParentIdList);
                    List<SysMenuVo> children = parent.getChildren();
                    if (children == null) {
                        children = new ArrayList<>();
                        parent.setChildren(children);
                    }
                    children.add(menu);
                }
            }
        }

        return rootMenus;
    }
}
