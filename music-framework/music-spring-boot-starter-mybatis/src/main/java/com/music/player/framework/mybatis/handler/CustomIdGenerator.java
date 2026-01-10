package com.music.player.framework.mybatis.handler;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.music.player.framework.id.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName : CustomIdGenerator<br>
 * Description : CustomIdGenerator<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@Component
public class CustomIdGenerator implements IdentifierGenerator {

    @Autowired
    private IdUtils idUtils;

    @Override
    public Long nextId(Object entity) {
        return idUtils.generateId();
    }
}
