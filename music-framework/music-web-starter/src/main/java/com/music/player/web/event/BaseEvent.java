package com.music.player.web.event;

import org.springframework.context.ApplicationEvent;

/**
 * ClassName : BaseEvent<br>
 * Description : BaseEvent<br>
 *
 * @author : sj
 * @date : 2024/9/12
 */
public class BaseEvent extends ApplicationEvent {

    private String desc;


    public BaseEvent(String desc) {
        super(desc);
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
