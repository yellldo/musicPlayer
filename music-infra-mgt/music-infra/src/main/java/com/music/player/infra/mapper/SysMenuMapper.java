package com.music.player.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.infra.dto.QuerySysMenuDto;
import com.music.player.infra.entity.SysMenu;
import com.music.player.infra.vo.QuerySysMenuVo;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName : SysMenuMapper<br>
 * Description : SysMenuMapper<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    IPage<QuerySysMenuVo> querySysMenu(Page<QuerySysMenuVo> page, @Param("querySysMenuDto") QuerySysMenuDto querySysMenuDto);

}
