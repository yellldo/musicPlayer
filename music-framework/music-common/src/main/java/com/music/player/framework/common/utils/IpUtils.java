package com.music.player.framework.common.utils;


import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName : IpUtils<br>
 * Description : IpUtils<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
public class IpUtils {

    /**
     * 获取客户端真实 IP（兼容代理情况，如 Nginx、CDN）
     */
    public static String getClientIp(HttpServletRequest request) {
        // 代理服务器传递的常见 header，按优先级排序
        List<String> headers = Arrays.asList(
                "X-Forwarded-For",
                "Proxy-Client-IP",
                "WL-Proxy-Client-IP",
                "HTTP_X_FORWARDED_FOR",
                "HTTP_X_FORWARDED",
                "HTTP_X_CLUSTER_CLIENT_IP",
                "HTTP_CLIENT_IP",
                "HTTP_FORWARDED_FOR",
                "HTTP_FORWARDED",
                "HTTP_VIA",
                "REMOTE_ADDR"
        );

        for (String header : headers) {
            String ip = request.getHeader(header);
            if (ip != null && !ip.isEmpty() && !"unknown".equalsIgnoreCase(ip)) {
                // X-Forwarded-For 可能有多个 IP，第一个是客户端真实 IP
                if ("X-Forwarded-For".equalsIgnoreCase(header)) {
                    // X-Forwarded-For: client, proxy1, proxy2
                    String[] ips = ip.split(",");
                    for (String realIp : ips) {
                        realIp = realIp.trim();
                        if (!"unknown".equalsIgnoreCase(realIp)) {
                            return realIp;
                        }
                    }
                } else {
                    return ip;
                }
            }
        }

        // 如果所有 header 都没有，使用 getRemoteAddr()
        return request.getRemoteAddr();
    }
}
