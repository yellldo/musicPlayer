package com.music.player.framework.log.event;


import org.springframework.context.ApplicationEvent;

/**
 * ClassName : HttpRequestLogEvent<br>
 * Description : HttpRequestLogEvent<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
public class HttpRequestLogEvent extends ApplicationEvent {


    public HttpRequestLogEvent(Object source) {
        super(source);
    }
}
