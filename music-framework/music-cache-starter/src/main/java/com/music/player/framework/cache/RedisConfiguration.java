package com.music.player.framework.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * ClassName : RedisConfiguration<br>
 * Description : redis缓存配置<br>
 *
 * @author : sj
 * @date : 2024/8/29
 */
@Configuration
@Slf4j
@ConditionalOnClass(RedisConnectionFactory.class)
public class RedisConfiguration {
}
