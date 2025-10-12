package com.music.player.framework.web.config;

import com.music.player.framework.web.handler.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@AutoConfiguration
public class MusicWebAutoConfiguration implements WebMvcConfigurer {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
