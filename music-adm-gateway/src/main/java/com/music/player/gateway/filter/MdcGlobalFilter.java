package com.music.player.gateway.filter;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * ClassName : MdcGlobalFilter<br>
 * Description : MdcGlobalFilter<br>
 *
 * @author : sj
 * @date : 11/2/25
 */
@Slf4j
@Component
public class MdcGlobalFilter implements GlobalFilter, Ordered {

    private static final String TRACE_ID = "traceId";


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1. 生成或获取 traceId（可以从请求头中获取，或生成新的）
        String traceId = exchange.getRequest().getHeaders().getFirst("X-Trace-Id");

        if (traceId == null || traceId.isBlank()) {
            traceId = IdUtil.fastUUID();
        }

        // 2. 将 traceId 和 userId 放入 MDC
        MDC.put(TRACE_ID, traceId);

        // 3. 继续执行过滤器链（请求转发到下游服务）
        return chain.filter(exchange)
                .doFinally(signalType -> {
                    // 5. 请求完成后清理 MDC，防止内存泄漏
                    MDC.clear();
                });
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
