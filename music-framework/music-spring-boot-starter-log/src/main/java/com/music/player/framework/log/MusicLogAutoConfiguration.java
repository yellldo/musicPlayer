package com.music.player.framework.log;


import com.music.player.framework.log.aspect.HttpRequestLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName : MusicLogAutoConfiguration<br>
 * Description : MusicLogAutoConfiguration<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Slf4j
@AutoConfiguration
public class MusicLogAutoConfiguration implements WebMvcConfigurer {


    @Bean
    public HttpRequestLogAspect httpRequestLogAspect() {
        return new HttpRequestLogAspect();
    }
}
