package com.music.player.adm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.adm.dto.QueryMenuListDto;
import com.music.player.adm.entity.SysMenu;
import com.music.player.adm.vo.SysMenuVo;

/**
 * ClassName : SysMenuService<br>
 * Description : SysMenuService<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
public interface SysMenuService extends IService<SysMenu> {

    IPage<SysMenuVo> queryMenuList(QueryMenuListDto queryMenuListDto);

}
