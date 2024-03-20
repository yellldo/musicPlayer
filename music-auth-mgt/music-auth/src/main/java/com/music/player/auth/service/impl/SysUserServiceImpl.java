package com.music.player.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.auth.entity.SysUser;
import com.music.player.auth.mapper.SysUserMapper;
import com.music.player.auth.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysUserServiceImpl<br>
 * Description : SysUserServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/3/20
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {
}
