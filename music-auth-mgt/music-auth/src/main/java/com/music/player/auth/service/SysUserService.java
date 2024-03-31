package com.music.player.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.auth.api.domain.UserDetails;
import com.music.player.auth.entity.SysUser;
import org.springframework.cache.annotation.Cacheable;

/**
 * ClassName : SysUserService<br>
 * Description : SysUserService<br>
 *
 * @author : sj
 * @date : 2024/3/20
 */
public interface SysUserService extends IService<SysUser> {

    @Cacheable(cacheNames = "sys:user:username", key = "#userName")
    public UserDetails loadUserByUserName(String userName);
}

