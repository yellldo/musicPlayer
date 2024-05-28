package com.music.player.infra.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.infra.dto.QuerySysRoleDto;
import com.music.player.infra.entity.SysRole;
import com.music.player.infra.vo.QuerySysRoleVo;

/**
 * ClassName : SysRoleService<br>
 * Description : SysRoleService<br>
 *
 * @author : sj
 * @date : 2024/5/24
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 查询角色列表
     *
     * @param querySysRoleDto
     * @return
     */
    IPage<QuerySysRoleVo> querySysRole(QuerySysRoleDto querySysRoleDto);
}
