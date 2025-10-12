package com.music.player.system.rest;

import com.music.player.framework.common.base.R;
import com.music.player.system.biz.SysMenuBiz;
import com.music.player.system.dto.SysMenuCreateDto;
import com.music.player.system.dto.SysMenuIdDto;
import com.music.player.system.dto.SysMenuUpdateDto;
import com.music.player.system.vo.SysMenuVo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("list")
    public R<List<SysMenuVo>> list() {
        return R.ok(sysMenuBiz.list());
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

}

