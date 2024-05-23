package com.music.player.infra.rest;

import com.music.player.framework.common.base.R;
import com.music.player.infra.api.dto.QuerySysMenuDto;
import com.music.player.infra.api.dto.SaveMenuDto;
import com.music.player.infra.api.service.SysMenuServiceFeign;
import com.music.player.infra.biz.SysMenuBiz;
import com.music.player.infra.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : SysMenuController<br>
 * Description : SysMenuController<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
@RestController
public class SysMenuController implements SysMenuServiceFeign {

    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysMenuBiz sysMenuBiz;

    @Override
    public R querySysMenu(QuerySysMenuDto querySysMenuDto) {
        return R.ok(sysMenuService.querySysMenu(querySysMenuDto));
    }

    @Override
    public R<Boolean> saveMenu(SaveMenuDto saveMenuDto) {
        return R.ok(sysMenuBiz.saveMenu(saveMenuDto));
    }
}
