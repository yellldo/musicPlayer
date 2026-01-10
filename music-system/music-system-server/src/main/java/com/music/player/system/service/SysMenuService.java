package com.music.player.system.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.music.player.framework.mybatis.core.service.IBaseService;
import com.music.player.system.entity.SysMenu;
import com.music.player.system.vo.SysMenuVo;

import java.util.List;

/**
 * ClassName : SysMenuService<br>
 * Description : SysMenuService<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@DS("system")
public interface SysMenuService extends IBaseService<SysMenu> {

    List<SysMenuVo> queryMenusByUserId(Long userId);


    List<String> getRoleMenuList(Long roleId);
}
