package com.music.player.auth.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.auth.api.domain.UserDetails;
import com.music.player.auth.dto.QuerySysUserListDto;
import com.music.player.auth.entity.SysUser;
import com.music.player.auth.vo.QuerySysUserListVo;
import org.springframework.cache.annotation.Cacheable;

/**
 * ClassName : SysUserService<br>
 * Description : SysUserService<br>
 *
 * @author : sj
 * @date : 2024/3/20
 */
public interface SysUserService extends IService<SysUser> {

    @Cacheable(cacheNames = "sys:user:loginname", key = "#loginname")
    UserDetails loadUserByLoginName(String loginname);


    IPage<QuerySysUserListVo> querySysUserList(QuerySysUserListDto querySysUserListDto);


}

