package com.music.player.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.auth.entity.SysMenu;
import com.music.player.auth.mapper.SysMenuMapper;
import com.music.player.auth.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysMenuServiceImpl<br>
 * Description : SysMenuServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
        implements SysMenuService {
}
