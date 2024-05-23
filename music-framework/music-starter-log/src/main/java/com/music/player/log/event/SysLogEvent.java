package com.music.player.log.event;

import com.music.player.log.annotation.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * ClassName : SysLogEvent<br>
 * Description : SysLogEvent<br>
 *
 * @author : sj
 * @date : 2024/5/16
 */
public class SysLogEvent extends ApplicationEvent {

    // TODO
    public SysLogEvent(SysLog source) {
        super(source);
    }
}
