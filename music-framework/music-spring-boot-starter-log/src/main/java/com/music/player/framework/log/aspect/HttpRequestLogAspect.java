package com.music.player.framework.log.aspect;


import com.alibaba.ttl.TransmittableThreadLocal;
import com.music.player.framework.common.utils.HttpContextUtil;
import com.music.player.framework.common.utils.SpringContextUtil;
import com.music.player.framework.log.annotation.HttpRequestLog;
import com.music.player.framework.log.event.HttpRequestLogEvent;
import com.music.player.framework.log.utils.LogUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Map;

/**
 * ClassName : HttpRequestLogAspect<br>
 * Description : HttpRequestLogAspect<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Slf4j
@Aspect
public class HttpRequestLogAspect {


    private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = new TransmittableThreadLocal<>();

    @Pointcut("@annotation(com.music.player.framework.log.annotation.HttpRequestLog)")
    public void logPrint() {
    }

    // 前置拦截
    @Before("logPrint()")
    public void log(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        HttpRequestLog httpRequestLog = signature.getMethod().getAnnotation(HttpRequestLog.class);
        HttpServletRequest httpServletRequest = HttpContextUtil.getHttpServletRequest();
        String url = httpServletRequest.getRequestURI();
        log.info("请求url：[{}],请求方法：[{}],请求入参：[{}]", url, httpRequestLog.logRemark(), joinPoint.getArgs());
    }

    // 后置通知
    @AfterReturning(returning = "ret", pointcut = "logPrint()")
    public void doAfterReturn(JoinPoint joinPoint, Object ret) {

    }


    // 异常通知，拦截记录异常日志
    @AfterThrowing(pointcut = "logPrint()", throwing = "e")
    public void doAfterThrow(JoinPoint joinPoint, Exception e) {
        HttpRequestLog httpRequestLog = LogUtils.getHttpRequestLog(joinPoint);
        if (checkRecord(httpRequestLog)) {
            return;
        }

        publishEvent();
    }

    /**
     * 检测是否需要记录日志
     */
    public boolean checkRecord(HttpRequestLog httpRequestLog) {
        return httpRequestLog == null || !httpRequestLog.enabled();
    }

    /**
     * 异步记录日志
     */
    public void publishEvent() {

        SpringContextUtil.publishEvent(new HttpRequestLogEvent(""));
    }

    public void buildHttpRequestLog() {

    }


}
