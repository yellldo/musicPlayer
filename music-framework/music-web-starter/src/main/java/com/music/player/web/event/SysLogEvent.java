package com.music.player.web.event;

import org.springframework.context.ApplicationEvent;

/**
 * ClassName : SysLogEvent<br>
 * Description : SysLogEvent<br>
 *
 * @author : sj
 * @date : 2024/9/9
 */
public class SysLogEvent extends ApplicationEvent {

    public SysLogEvent(Object source) {
        super(source);
    }
}
