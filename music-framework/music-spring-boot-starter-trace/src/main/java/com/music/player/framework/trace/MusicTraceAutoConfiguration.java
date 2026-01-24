package com.music.player.framework.trace;

import com.music.player.framework.trace.filter.TraceIdFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

/**
 * ClassName : MusicTraceAutoConfiguration<br>
 * Description : MusicTraceAutoConfiguration<br>
 *
 * @author : sj
 * @date : 1/14/26
 */
@Slf4j
@AutoConfiguration
public class MusicTraceAutoConfiguration {

    @Bean
    public FilterRegistrationBean<TraceIdFilter> traceIdFilterRegistration(TraceIdFilter filter) {
        log.info("注册 TraceIdFilter");
        FilterRegistrationBean<TraceIdFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registration.addUrlPatterns("/*");
        return registration;
    }
}
