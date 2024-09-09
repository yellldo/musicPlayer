package com.music.player.infra.api;

import com.music.player.infra.api.service.log.dto.SaveSysLogDto;
import com.music.player.infra.api.service.log.SysLogServiceApi;
import com.music.player.infra.convert.SysLogConvert;
import com.music.player.infra.entity.SysLog;
import com.music.player.infra.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : SysLogServiceApiImpl<br>
 * Description : SysLogServiceApiImpl<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@RestController
public class SysLogServiceApiImpl implements SysLogServiceApi {

    @Autowired
    private SysLogService sysLogService;

    @Override
    public void saveSysLog(SaveSysLogDto saveLogDto) {
        SysLog sysLog = SysLogConvert.INSTANT.saveSysLog(saveLogDto);
        sysLogService.save(sysLog);
    }
}
