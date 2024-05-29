package com.music.player.infra.rest;

import com.music.player.framework.common.base.R;
import com.music.player.infra.biz.SysMenuBiz;
import com.music.player.infra.dto.QuerySysMenuDto;
import com.music.player.infra.dto.SaveMenuDto;
import com.music.player.infra.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * ClassName : SysMenuCtrl<br>
 * Description : SysMenuCtrl<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
@RestController
@RequestMapping("menu")
public class SysMenuCtrl {

    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysMenuBiz sysMenuBiz;

    @PostMapping("querySysMenu")
    public R querySysMenu(@RequestBody QuerySysMenuDto querySysMenuDto) {
        return R.ok(sysMenuService.querySysMenu(querySysMenuDto));
    }

    @PostMapping("saveMenu")
    public R<Boolean> saveMenu(@RequestBody @Valid SaveMenuDto saveMenuDto) {
        return R.ok(sysMenuBiz.saveMenu(saveMenuDto));
    }
}
