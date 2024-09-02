package com.music.player.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.auth.entity.SysUserRole;
import com.music.player.auth.mapper.SysUserRoleMapper;
import com.music.player.auth.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysUserRoleServiceImpl<br>
 * Description : SysUserRoleServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole>
        implements SysUserRoleService {
}
