package com.music.player.web.config;

import com.music.player.web.annotation.LogRecord;
import com.music.player.web.aop.LogRecordAnnotationAdvisor;
import com.music.player.web.aop.LogRecordInterceptor;
import com.music.player.web.event.SysLogListener;
import com.music.player.web.publisher.SysLogPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
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
@Import(MusicLogProperties.class)
public class DefaultWebConfig implements WebMvcConfigurer {


    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "security.log.enabled", havingValue = "true")
    public LogRecordInterceptor logRecordInterceptor() {
        return new LogRecordInterceptor();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "security.log.enabled", havingValue = "true")
    public LogRecordAnnotationAdvisor logRecordAnnotationAdvisor(LogRecordInterceptor logRecordInterceptor) {
        return new LogRecordAnnotationAdvisor(logRecordInterceptor, LogRecord.class, Ordered.HIGHEST_PRECEDENCE);
    }


    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(MusicLogProperties.class)
    @ConditionalOnProperty(name = "security.log.enabled", havingValue = "true")
    public SysLogListener sysLogListener() {
        return new SysLogListener();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(MusicLogProperties.class)
    @ConditionalOnProperty(name = "security.log.enabled", havingValue = "true")
    public SysLogPublisher sysLogPublisher() {
        return new SysLogPublisher();
    }
}
