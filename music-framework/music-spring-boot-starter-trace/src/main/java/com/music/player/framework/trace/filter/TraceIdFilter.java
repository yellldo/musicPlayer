package com.music.player.framework.trace.filter;

import com.music.player.framework.trace.constant.TraceConstant;
import com.music.player.framework.trace.utils.TraceIdUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * ClassName : TraceIdFilter<br>
 * Description : TraceIdFilter<br>
 *
 * @author : sj
 * @date : 1/14/26
 */
@Component
public class TraceIdFilter implements Filter {

    // 定义 MDC 中的 key

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        try {
            // 尝试从请求头中获取 traceId（用于跨服务传递）
            String traceId = httpRequest.getHeader("X-Trace-Id");
            if (traceId == null || traceId.isBlank()) {
                // 没有则生成一个新的
                traceId = TraceIdUtil.generateTraceId();
            }

            // 放入 MDC
            MDC.put(TraceConstant.TRACE_ID_MDC_KEY, traceId);

            // 继续执行过滤器链
            chain.doFilter(request, response);
        } finally {
            // 请求完成后清理 MDC，防止线程复用导致数据错乱
            MDC.remove(TraceConstant.TRACE_ID_MDC_KEY);
        }

    }
}
