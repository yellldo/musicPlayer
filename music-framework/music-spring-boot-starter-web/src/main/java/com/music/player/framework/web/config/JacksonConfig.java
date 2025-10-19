package com.music.player.framework.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName : JacksonConfig<br>
 * Description : JacksonConfig<br>
 *
 * @author : sj
 * @date : 10/15/25
 */
//@Configuration
public class JacksonConfig {

    //    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // 注册 Java 8 时间模块，支持 LocalDateTime 等
        objectMapper.registerModule(new JavaTimeModule());
        // 可选：让日期以字符串形式输出，而不是时间戳
        objectMapper.disable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }
}
