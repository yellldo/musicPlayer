package com.music.player.framework.id.service;

import cn.hutool.core.lang.Snowflake;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName : IdGeneratorService<br>
 * Description : IdGeneratorService<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
public class IdGeneratorService {


    @Autowired(required = false)
    private Snowflake snowflake;


    public Long generateId() {
        return snowflake.nextId();
    }

}
