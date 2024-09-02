package com.music.player.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.auth.entity.SysRole;
import com.music.player.auth.mapper.SysRoleMapper;
import com.music.player.auth.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysRoleServiceImpl<br>
 * Description : SysRoleServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
        implements SysRoleService {
}
