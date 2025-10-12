package com.music.player.system.service.impl;

import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import com.music.player.system.entity.SysMenu;
import com.music.player.system.mapper.SysMenuMapper;
import com.music.player.system.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysMenuServiceImpl<br>
 * Description : SysMenuServiceImpl<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
}
