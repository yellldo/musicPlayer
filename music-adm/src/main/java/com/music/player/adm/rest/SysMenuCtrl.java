package com.music.player.adm.rest;

import com.music.player.adm.biz.SysMenuBiz;
import com.music.player.adm.dto.QueryMenuListDto;
import com.music.player.adm.dto.SaveSysMenuDto;
import com.music.player.adm.service.SysMenuService;
import com.music.player.framework.common.base.R;
import com.music.player.web.annotation.LogRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * ClassName : SysMenuCtrl<br>
 * Description : SysMenuCtrl<br>
 *
 * @author : sj
 * @date : 2024/9/12
 */

@RestController
@Api(tags = "菜单管理")
@RequestMapping("sysMenu")
public class SysMenuCtrl {

    @Autowired
    private SysMenuBiz sysMenuBiz;
    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation("添加菜单")
    @LogRecord("添加菜单")
    @PostMapping("saveSysMenu")
    public R saveSysMenu(@RequestBody @Valid SaveSysMenuDto saveSysMenuDto) {
        sysMenuBiz.saveSysMenu(saveSysMenuDto);
        return R.ok();
    }


    @ApiOperation("查询菜单列表")
    @GetMapping("queryMenuList")
    public R queryMenuList(QueryMenuListDto queryMenuListDto) {
        return R.ok(sysMenuService.queryMenuList(queryMenuListDto));
    }

}
