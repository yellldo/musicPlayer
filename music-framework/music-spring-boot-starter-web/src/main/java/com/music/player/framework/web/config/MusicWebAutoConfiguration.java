package com.music.player.framework.web.config;

import com.music.player.framework.web.handler.GlobalExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName : MusicWebAutoConfiguration<br>
 * Description : MusicWebAutoConfiguration<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@AutoConfiguration
public class MusicWebAutoConfiguration implements WebMvcConfigurer {

    /**
     * 应用名
     */
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler(applicationName);
    }
}
