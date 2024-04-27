package com.music.player.framework.web.config;

import com.music.player.framework.common.enmus.WebFilterOrderEnum;
import com.music.player.framework.common.utils.BaseContextHandler;
import com.music.player.framework.web.core.filter.CacheRequestBodyFilter;
import com.music.player.framework.web.core.handler.GlobalExceptionAdvice;
import com.music.player.infra.api.service.ApiAccessLogFeign;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.music.player.framework.xss.config.MusicXssAutoConfiguration.createFilterBean;

/**
 * ClassName : MusicWebConfiguration<br>
 * Description : MusicWebConfiguration<br>
 *
 * @author : sj
 * @date : 2024/4/3
 */
@Primary
@AutoConfiguration
public class MusicWebConfiguration implements WebMvcConfigurer {

    /**
     * 应用名
     */
    @Value("${spring.application.name}")
    private String applicationName;
    private ApiAccessLogFeign apiAccessLogFeign;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(traceFlowInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public TraceFlowInterceptor traceFlowInterceptor() {
        return new TraceFlowInterceptor();
    }

    @Bean
    public GlobalExceptionAdvice globalExceptionHandler(ApiAccessLogFeign apiAccessLogFeign) {
        return new GlobalExceptionAdvice(applicationName, apiAccessLogFeign);
    }

    @Bean
    public FilterRegistrationBean<CacheRequestBodyFilter> requestBodyCacheFilter() {
        return createFilterBean(new CacheRequestBodyFilter(), WebFilterOrderEnum.REQUEST_BODY_CACHE_FILTER);
    }


    /**
     * 传递系统跟踪号
     */
    private class TraceFlowInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String ip = request.getHeader("x-client-ip-header");
            BaseContextHandler.set("currentClientIp", ip);
            MDC.put("requestId", request.getHeader("x-trace-id-header"));
            String traceFlow = request.getHeader("traceFlow");
            MDC.put("traceFlow", traceFlow);
            BaseContextHandler.set("traceId", request.getHeader("x-trace-id-header"));
            BaseContextHandler.set("traceFlow", traceFlow);
            return super.preHandle(request, response, handler);
        }
    }
}
