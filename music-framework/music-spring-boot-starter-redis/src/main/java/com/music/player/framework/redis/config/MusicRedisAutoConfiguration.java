package com.music.player.framework.redis.config;

import com.music.player.framework.redis.domain.RedisOps;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * ClassName : MusicRedisAutoConfiguration<br>
 * Description : MusicRedisAutoConfiguration<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@AutoConfiguration
public class MusicRedisAutoConfiguration {

    @Bean
    @ConditionalOnClass(RedisOperations.class)
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // key采用 String的序列化方式
        template.setKeySerializer(new StringRedisSerializer());
        // hash的 key也采用 String的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        // value序列化方式采用 jackson
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // hash的 value序列化方式采用 jackson
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 开启事务
        template.setEnableTransactionSupport(true);
        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(factory);
        return template;
    }


    @Bean
    @ConditionalOnMissingBean
    public RedisOps redisOps(RedisTemplate<String, Object> redisTemplate, StringRedisTemplate stringRedisTemplate) {
        return new RedisOps(redisTemplate, stringRedisTemplate);
    }
}
