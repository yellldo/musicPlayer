package com.music.player.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.auth.entity.SysRoleMenu;
import com.music.player.auth.mapper.SysRoleMenuMapper;
import com.music.player.auth.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysRoleMenuServiceImpl<br>
 * Description : SysRoleMenuServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu>
        implements SysRoleMenuService {
}
