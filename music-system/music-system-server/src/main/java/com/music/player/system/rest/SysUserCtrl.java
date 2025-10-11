package com.music.player.system.rest;


import com.music.player.framework.common.base.R;
import com.music.player.system.biz.SysUserBiz;
import com.music.player.system.dto.CreateSysUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : SysUserCtrl<br>
 * Description : SysUserCtrl<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Slf4j
@RestController
@RequestMapping("sysUser")
public class SysUserCtrl {

    @Autowired
    private SysUserBiz sysUserBiz;

    @PostMapping("create")
    public R create(@RequestBody CreateSysUserDto createSysUserDto) {
        sysUserBiz.create(createSysUserDto);
        return R.ok();
    }


}
