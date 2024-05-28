package com.music.player.infra.rest;

import com.music.player.framework.common.base.R;
import com.music.player.infra.dto.QuerySysLogDto;
import com.music.player.infra.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : SysLogCtrl<br>
 * Description : SysLogCtrl<br>
 *
 * @author : sj
 * @date : 2024/5/28
 */
@RestController
@RequestMapping("log")
public class SysLogCtrl {

    @Autowired
    private SysLogService sysLogService;

    @PostMapping("querySysLog")
    public R querySysLog(@RequestBody QuerySysLogDto querySysLogDto) {
        return R.ok(sysLogService.querySysLog(querySysLogDto));
    }


}
