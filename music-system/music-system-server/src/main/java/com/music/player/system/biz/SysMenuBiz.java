package com.music.player.system.biz;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.music.player.framework.redis.domain.RedisOps;
import com.music.player.system.convert.SysMenuConvert;
import com.music.player.system.dto.SysMenuCreateDto;
import com.music.player.system.dto.SysMenuIdDto;
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


    public List<SysMenuVo> list() {
        List<SysMenu> sysMenus = sysMenuService.selectList(new LambdaQueryWrapperX<SysMenu>()
                .eq(SysMenu::getIsDelete, CommonConstants.STATUS_NOT_DEL));

        return buildMenuTree(sysMenus);
    }

    public void update(SysMenuUpdateDto sysMenuUpdateDto) {
        sysMenuService.updateById(SysMenuConvert.INSTANT.update(sysMenuUpdateDto));
    }

    public void delete(SysMenuIdDto sysMenuIdDto) {
        SysMenu sysMenu = new SysMenu().setMenuId(sysMenuIdDto.getMenuId());
        sysMenu.setIsDelete(CommonConstants.STATUS_DEL);
        sysMenuService.updateById(sysMenu);
    }


    public List<SysMenuVo> buildMenuTree(List<SysMenu> menus) {
        // 1. 按层级分组
        Map<Integer, List<SysMenuVo>> menuByLevel = menus.stream()
                .collect(Collectors.groupingBy(
                        SysMenu::getLevel,
                        Collectors.mapping(SysMenuConvert.INSTANT::copy, Collectors.toList())
                ));

        // 2. 按 parentId 分组二级和三级菜单
        Map<Long, List<SysMenuVo>> layerSec = menuByLevel.getOrDefault(1, new ArrayList<>())
                .stream()
                .collect(Collectors.groupingBy(SysMenuVo::getParentId));

        Map<Long, List<SysMenuVo>> layerThr = menuByLevel.getOrDefault(2, new ArrayList<>())
                .stream()
                .collect(Collectors.groupingBy(SysMenuVo::getParentId));

        // 3. 构建树形结构
        List<SysMenuVo> result = menuByLevel.getOrDefault(0, new ArrayList<>());
        result.forEach(menu -> {
            List<SysMenuVo> children = layerSec.getOrDefault(menu.getMenuId(), new ArrayList<>());
            children.forEach(child -> child.setChild(layerThr.getOrDefault(child.getMenuId(), new ArrayList<>())));
            menu.setChild(children);
        });

        return result;
    }
}
