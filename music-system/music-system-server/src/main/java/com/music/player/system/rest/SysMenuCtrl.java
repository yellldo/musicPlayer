package com.music.player.system.rest;

import cn.dev33.satoken.stp.StpUtil;
import com.music.player.framework.common.base.R;
import com.music.player.system.biz.SysMenuBiz;
import com.music.player.system.dto.SysMenuCreateDto;
import com.music.player.system.dto.SysMenuIdDto;
import com.music.player.system.dto.SysMenuPageDto;
import com.music.player.system.dto.SysMenuUpdateDto;
import com.music.player.system.vo.SysMenuVo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName : SysMenuCtrl<br>
 * Description : SysMenuCtrl<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@RestController
@RequestMapping("sysMenu")
public class SysMenuCtrl {

    @Autowired
    private SysMenuBiz sysMenuBiz;


    @PostMapping("create")
    public R<?> create(@RequestBody SysMenuCreateDto sysMenuCreateDto) {
        sysMenuBiz.create(sysMenuCreateDto);
        return R.ok();
    }

    @GetMapping("page")
    public R<?> page(SysMenuPageDto sysMenuPageDto) {
        return R.ok(sysMenuBiz.page(sysMenuPageDto));
    }


    @GetMapping("build")
    public R<List<SysMenuVo>> buildMenus() {
        return R.ok(sysMenuBiz.buildMenus(StpUtil.getLoginIdAsLong()));
    }

    @PostMapping("update")
    public R update(@Valid @RequestBody SysMenuUpdateDto sysMenuUpdateDto) {
        sysMenuBiz.update(sysMenuUpdateDto);
        return R.ok();
    }

    @PostMapping("delete")
    public R<?> delete(@Valid @RequestBody SysMenuIdDto sysMenuIdDto) {
        sysMenuBiz.delete(sysMenuIdDto);
        return R.ok();
    }

    @GetMapping("tree")
    public R<?> tree() {
        return R.ok(sysMenuBiz.tree());
    }
}

