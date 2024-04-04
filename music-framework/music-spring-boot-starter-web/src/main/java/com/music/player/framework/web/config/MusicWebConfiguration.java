package com.music.player.framework.web.config;

import com.music.player.framework.common.utils.BaseContextHandler;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName : MusicWebConfiguration<br>
 * Description : MusicWebConfiguration<br>
 *
 * @author : sj
 * @date : 2024/4/3
 */
@Primary
@Configuration
public class MusicWebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(traceFlowInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Bean
    public TraceFlowInterceptor traceFlowInterceptor() {
        return new TraceFlowInterceptor();
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
