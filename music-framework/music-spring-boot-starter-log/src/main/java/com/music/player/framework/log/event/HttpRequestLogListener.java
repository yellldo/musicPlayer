package com.music.player.framework.log.event;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import java.util.function.Consumer;

/**
 * ClassName : HttpRequestLogListener<br>
 * Description : HttpRequestLogListener<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Slf4j
@AllArgsConstructor
public class HttpRequestLogListener {

    private final Consumer<Object> consumer;

    @Async
    @EventListener(HttpRequestLogEvent.class)
    public void saveRequestLog(HttpRequestLogEvent event) {

    }

}
