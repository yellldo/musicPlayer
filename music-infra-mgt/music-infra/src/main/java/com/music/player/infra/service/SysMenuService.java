package com.music.player.infra.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.infra.dto.QuerySysMenuDto;
import com.music.player.infra.entity.SysMenu;
import com.music.player.infra.vo.QuerySysMenuVo;

/**
 * ClassName : SysMenuService<br>
 * Description : SysMenuService<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 查询日志
     *
     * @param querySysMenuDto
     * @return
     */
    IPage<QuerySysMenuVo> querySysMenu(QuerySysMenuDto querySysMenuDto);
}
