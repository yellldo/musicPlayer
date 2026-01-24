package com.music.player.framework.trace.filter;

import com.music.player.framework.trace.constant.TraceConstant;
import com.music.player.framework.trace.utils.TraceIdUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * ClassName : GatewayTraceIdFilter<br>
 * Description : GatewayTraceIdFilter<br>
 *
 * @author : sj
 * @date : 1/14/26
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GatewayTraceIdFilter implements GlobalFilter {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 生成或获取 traceId
        String traceId = exchange.getRequest().getHeaders().getFirst(TraceConstant.TRACE_ID_HEADER);
        if (traceId == null || traceId.isBlank()) {
            traceId = TraceIdUtil.generateTraceId();
        }

        // 添加到响应头（可选，便于前端调试）
        ServerHttpRequest mutatedRequest = exchange.getRequest()
                .mutate()
                .header(TraceConstant.TRACE_ID_HEADER, traceId)
                .build();

        // 设置 MDC（注意：Reactor Context 中传递）
        String finalTraceId = traceId;
        return chain.filter(exchange.mutate().request(mutatedRequest).build())
                .contextWrite(ctx -> ctx.put(TraceConstant.TRACE_ID_MDC_KEY, finalTraceId));
    }
}
