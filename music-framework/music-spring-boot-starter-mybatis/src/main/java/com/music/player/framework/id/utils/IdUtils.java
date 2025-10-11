package com.music.player.framework.id.utils;

import cn.hutool.core.util.IdUtil;
import com.music.player.framework.id.service.IdGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName : IdUtils<br>
 * Description : IdUtils<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Slf4j
public class IdUtils implements InitializingBean {

    @Autowired(required = false)
    private IdGeneratorService idGeneratorService;


    public Long generateId() {
        if (idGeneratorService == null) {
            return IdUtil.getSnowflake().nextId();
        }
        return idGeneratorService.generateId();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (idGeneratorService == null) {
            log.warn("未配置雪花算法，用hutool替代");
        }
    }
}
