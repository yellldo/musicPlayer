package com.music.player.framework.trace.feign;

import com.music.player.framework.trace.constant.TraceConstant;
import feign.RequestInterceptor;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName : FeignTraceIdInterceptor<br>
 * Description : FeignTraceIdInterceptor<br>
 *
 * @author : sj
 * @date : 1/14/26
 */
@Configuration
public class FeignTraceIdInterceptor {

    @Bean
    public RequestInterceptor traceIdInterceptor() {
        return template -> {
            String traceId = MDC.get(TraceConstant.TRACE_ID_HEADER);
            if (traceId != null && !traceId.isEmpty()) {
                template.header("X-Trace-Id", traceId);
            }
        };
    }
}
