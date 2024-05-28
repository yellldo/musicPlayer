package com.music.player.infra.rest;

import com.music.player.framework.common.base.R;
import com.music.player.infra.api.dto.SaveLogDto;
import com.music.player.infra.api.service.SysLogServiceFeign;
import com.music.player.infra.biz.SysLogBiz;
import com.music.player.infra.service.SysLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : SysLogController<br>
 * Description : SysLogController<br>
 *
 * @author : sj
 * @date : 2024/5/19
 */
@RestController
@Tag(description = "log", name = "日志管理模块")
public class SysLogController implements SysLogServiceFeign {

    @Autowired
    private SysLogBiz sysLogBiz;
    @Autowired
    private SysLogService sysLogService;

    @Override
    public R<Boolean> saveLog(SaveLogDto saveLogDto) {
        return R.ok(sysLogBiz.saveLog(saveLogDto));
    }


}
