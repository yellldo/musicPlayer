package com.music.player.web.config;

import com.music.player.web.annotation.LogRecord;
import com.music.player.web.aop.LogRecordAnnotationAdvisor;
import com.music.player.web.aop.LogRecordInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName : DefaultWebConfig<br>
 * Description : WebConfig全局配置<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@Configuration
@Slf4j
public class DefaultWebConfig implements WebMvcConfigurer {


    @Bean
    @ConditionalOnMissingBean
    public LogRecordInterceptor logRecordInterceptor() {
        return new LogRecordInterceptor();
    }

    @Bean
    @ConditionalOnMissingBean
    public LogRecordAnnotationAdvisor logRecordAnnotationAdvisor(LogRecordInterceptor logRecordInterceptor) {
        return new LogRecordAnnotationAdvisor(logRecordInterceptor, LogRecord.class, Ordered.HIGHEST_PRECEDENCE);
    }
}
