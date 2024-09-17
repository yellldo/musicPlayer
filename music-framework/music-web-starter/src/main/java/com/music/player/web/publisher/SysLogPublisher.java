package com.music.player.web.publisher;

import com.music.player.web.event.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * ClassName : SysLogPublisher<br>
 * Description : SysLogPublisher<br>
 *
 * @author : sj
 * @date : 2024/9/12
 */
@Component
@Slf4j
public class SysLogPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(BaseEvent event) {
        applicationEventPublisher.publishEvent(event);
        log.info("事件[{}]发布成功", event.getDesc());
    }

}
