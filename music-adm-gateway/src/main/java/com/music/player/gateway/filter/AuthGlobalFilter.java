package com.music.player.gateway.filter;

import cn.dev33.satoken.stp.StpUtil;
import com.music.player.framework.redis.domain.RedisOps;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * ClassName : AuthGlobalFilter<br>
 * Description : AuthGlobalFilter<br>
 *
 * @author : sj
 * @date : 10/28/25
 */
@Slf4j
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Autowired
    private RedisOps redisOps;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1. 获取请求信息
        String path = exchange.getRequest().getPath().toString();
        log.info("【全局拦截】请求路径: {}", path);

        if (path.contains("/auth/login")) {
            return chain.filter(exchange);
        }

        // 2. 简单 Token 校验（从 Header 中获取）
        List<String> tokenList = exchange.getRequest().getHeaders().get("Authorization");
        if (tokenList == null || tokenList.isEmpty() || !tokenList.get(0).startsWith("Bearer ")) {
            log.info("【拦截】未携带合法 Token");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        String token = tokenList.get(0).substring(7);

        Long userId = redisOps.get("satoken:login:token:" + token, false);

        exchange.getRequest().mutate()
                .header("userId", String.valueOf(userId))
                .build();

        // 3. 如果校验通过，继续执行后续过滤器或路由
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -2;
    }
}
