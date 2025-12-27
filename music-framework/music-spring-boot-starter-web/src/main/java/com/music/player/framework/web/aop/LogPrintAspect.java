package com.music.player.framework.web.aop;

import com.music.player.framework.web.annotation.LogPrint;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

/**
 * ClassName : LogPrintAspect<br>
 * Description : LogPrintAspect<br>
 *
 * @author : sj
 * @date : 10/30/25
 */
@Slf4j
@Aspect
@Component
public class LogPrintAspect {

    @Pointcut("@annotation(com.music.player.framework.web.annotation.LogPrint)")
    public void logPrint() {

    }

    /**
     * 切入点：拦截所有 Controller 包下的 public 方法
     * 你可以根据需要调整切入点表达式
     */
    @Before("logPrint()")
    public void logControllerMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        LogPrint logPrint = signature.getMethod().getAnnotation(LogPrint.class);
        if (!logPrint.enable()) {
            return;
        }

        // 获取当前请求对象（如果有）
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes != null ? attributes.getRequest() : null;

        // 获取方法签名信息
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();

        // 打印方法调用开始日志
        log.info("======= LogPrint 方法调用开始 =======");
        if (request != null) {
            log.info("请求 URL: {},请求 IP: {}", request.getRequestURL(), request.getRemoteAddr());
        }
        if (!logPrint.module().isEmpty()) {
            log.info("模块: {}", logPrint.module());
        }
        if (!logPrint.operation().isEmpty()) {
            log.info("操作: {}", logPrint.operation());
        }
        log.info("方法参数: {}", getParamString(parameterNames, args));
    }

    /**
     * 辅助方法：将参数名和参数值拼接成可读字符串
     */
    private String getParamString(String[] paramNames, Object[] paramValues) {
        if (paramNames == null || paramValues == null || paramNames.length != paramValues.length) {
            return Arrays.toString(paramValues);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paramNames.length; i++) {
            sb.append(paramNames[i]).append("=").append(paramValues[i]);
            if (i < paramNames.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
