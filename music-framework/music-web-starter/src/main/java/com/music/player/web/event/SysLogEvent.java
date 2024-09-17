package com.music.player.web.event;

import com.music.player.infra.api.service.log.dto.SaveSysLogDto;
import lombok.Getter;

/**
 * ClassName : SysLogEvent<br>
 * Description : SysLogEvent<br>
 *
 * @author : sj
 * @date : 2024/9/9
 */
@Getter
public class SysLogEvent extends BaseEvent {

    private SaveSysLogDto saveSysLogDto;


    public SysLogEvent(String desc, SaveSysLogDto saveSysLogDto) {
        super(desc);
        this.saveSysLogDto = saveSysLogDto;
    }
}
