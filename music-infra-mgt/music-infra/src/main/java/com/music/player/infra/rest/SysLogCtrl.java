package com.music.player.infra.rest;

import com.music.player.framework.common.base.R;
import com.music.player.infra.dto.QuerySysLogDto;
import com.music.player.infra.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : SysLogCtrl<br>
 * Description : SysLogCtrl<br>
 *
 * @author : sj
 * @date : 2024/9/22
 */
@RestController
@RequestMapping("sysLog")
public class SysLogCtrl {

    @Autowired
    private SysLogService sysLogService;

    @GetMapping("querySysLog")
    public R querySysLog(QuerySysLogDto querySysLogDto) {
        return R.ok(sysLogService.querySysLog(querySysLogDto));
    }


}
