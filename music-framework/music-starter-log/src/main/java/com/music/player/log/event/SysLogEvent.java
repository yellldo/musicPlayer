package com.music.player.log.event;

import com.music.player.infra.api.dto.SysLogDto;
import org.springframework.context.ApplicationEvent;

/**
 * ClassName : SysLogEvent<br>
 * Description : SysLogEvent<br>
 *
 * @author : sj
 * @date : 2024/5/16
 */
public class SysLogEvent extends ApplicationEvent {

    public SysLogEvent(SysLogDto source) {
        super(source);
    }
}
