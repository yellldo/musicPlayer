package com.music.player.infra.biz;

import com.music.player.infra.api.dto.SaveLogDto;
import com.music.player.infra.convert.SysLogConvert;
import com.music.player.infra.entity.SysLog;
import com.music.player.infra.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName : SysLogBiz<br>
 * Description : SysLogBiz<br>
 *
 * @author : sj
 * @date : 2024/5/19
 */
@Service
public class SysLogBiz {

    @Autowired
    private SysLogService sysLogService;

    @Transactional(rollbackFor = Exception.class)
    public Boolean saveLog(SaveLogDto saveLogDto) {
        SysLog sysLog = SysLogConvert.INSTANT.saveLog(saveLogDto);
        sysLogService.save(sysLog);
        return Boolean.TRUE;
    }

}
