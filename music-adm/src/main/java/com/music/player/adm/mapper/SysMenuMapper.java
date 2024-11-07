package com.music.player.adm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.adm.dto.QueryMenuListDto;
import com.music.player.adm.entity.SysMenu;
import com.music.player.adm.vo.SysMenuVo;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName : SysMenuMapper<br>
 * Description : SysMenuMapper<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {


    public IPage<SysMenuVo> queryMenuList(Page<SysMenuVo> page, @Param("queryMenuListDto") QueryMenuListDto queryMenuListDto);
}
