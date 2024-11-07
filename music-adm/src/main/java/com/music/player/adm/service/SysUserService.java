package com.music.player.adm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.adm.dto.QuerySysUserListDto;
import com.music.player.adm.entity.SysUser;
import com.music.player.adm.vo.QuerySysUserListVo;
import com.music.player.adm.vo.UserDetails;
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

