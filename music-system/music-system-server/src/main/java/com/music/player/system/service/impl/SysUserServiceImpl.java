package com.music.player.system.service.impl;


import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import com.music.player.system.entity.SysUser;
import com.music.player.system.mapper.SysUserMapper;
import com.music.player.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysUserServiceImpl<br>
 * Description : SysUserServiceImpl<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
