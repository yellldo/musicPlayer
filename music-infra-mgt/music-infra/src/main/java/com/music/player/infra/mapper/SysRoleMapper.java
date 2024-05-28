package com.music.player.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.infra.dto.QuerySysRoleDto;
import com.music.player.infra.entity.SysRole;
import com.music.player.infra.vo.QuerySysRoleVo;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName : SysRoleMapper<br>
 * Description : SysRoleMapper<br>
 *
 * @author : sj
 * @date : 2024/5/24
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    IPage<QuerySysRoleVo> querySysRole(Page<QuerySysRoleVo> page, @Param("querySysRoleDto") QuerySysRoleDto querySysRoleDto);
}
