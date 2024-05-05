package com.music.player.framework.cache.serializer;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.music.player.framework.common.json.impl.jackson.JacksonImpl;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * ClassName : RedisObjectSerializer<br>
 * Description : RedisObjectSerializer<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public class RedisObjectSerializer extends Jackson2JsonRedisSerializer<Object> {

    public RedisObjectSerializer() {
        super(Object.class);
        JacksonImpl jackson = new JacksonImpl();
        ObjectMapper objectMapper = jackson.objectMapper;
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.WRAPPER_ARRAY);
        this.setObjectMapper(objectMapper);
    }
}
