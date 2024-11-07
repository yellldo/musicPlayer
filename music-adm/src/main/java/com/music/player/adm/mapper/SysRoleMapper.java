package com.music.player.adm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.adm.dto.QueryRoleListDto;
import com.music.player.adm.entity.SysRole;
import com.music.player.adm.vo.SysRoleVo;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName : SysMenuMapper<br>
 * Description : SysMenuMapper<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {


    IPage<SysRoleVo> queryRoleList(Page<SysRoleVo> page, @Param("queryRoleListDto") QueryRoleListDto queryRoleListDto);
}
