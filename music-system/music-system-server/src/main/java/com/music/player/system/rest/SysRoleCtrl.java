package com.music.player.system.rest;

import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.R;
import com.music.player.system.biz.SysRoleBiz;
import com.music.player.system.dto.SysRoleCreateDto;
import com.music.player.system.dto.SysRolePageDto;
import com.music.player.system.vo.SysRoleVo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : SysRoleCtrl<br>
 * Description : SysRoleCtrl<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Slf4j
@RestController
@RequestMapping("sysRole")
public class SysRoleCtrl {

    @Autowired
    private SysRoleBiz sysRoleBiz;

    /**
     * create a role
     */
    @PostMapping("create")
    public R<?> create(@Valid @RequestBody SysRoleCreateDto sysRoleCreateDto) {
        sysRoleBiz.create(sysRoleCreateDto);
        return R.ok();
    }

    @PostMapping("page")
    public R<PageResult<SysRoleVo>> page(@RequestBody SysRolePageDto sysRolePageDto) {
        return R.ok(sysRoleBiz.page(sysRolePageDto));
    }
}
