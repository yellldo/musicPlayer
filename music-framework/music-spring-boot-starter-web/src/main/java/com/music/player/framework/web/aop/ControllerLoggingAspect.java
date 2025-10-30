package com.music.player.framework.web.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

/**
 * ClassName : ControllerLoggingAspect<br>
 * Description : ControllerLoggingAspect<br>
 *
 * @author : sj
 * @date : 10/30/25
 */
@Slf4j
@Aspect
@Component
public class ControllerLoggingAspect {


    /**
     * 切入点：拦截所有 Controller 包下的 public 方法
     * 你可以根据需要调整切入点表达式
     */
    @Around("execution(public * com.music.player..*.*(..))")
    public Object logControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 获取当前请求对象（如果有）
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes != null ? attributes.getRequest() : null;

        // 获取方法签名信息
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = signature.getMethod().getName();
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();

        // 打印请求信息
        log.info("======= Controller 方法调用开始 =======");
        if (request != null) {
            log.info("请求 URL        : {}", request.getRequestURL());
            log.info("请求方法        : {}", request.getMethod());
            log.info("请求 IP         : {}", request.getRemoteAddr());
        }
        log.info("类名            : {}", className);
        log.info("方法名          : {}", methodName);
        log.info("方法参数名和值  : {}", getParamString(parameterNames, args));

        // 执行目标方法，并获取返回值
        Object result;
        try {
            result = joinPoint.proceed(); // 执行原方法
        } catch (Throwable e) {
            log.error("方法执行异常    : {}", e.getMessage(), e);
            throw e; // 继续抛出异常
        }

        // 打印返回结果和方法耗时
        long endTime = System.currentTimeMillis();
        log.info("方法返回值      : {}", result);
        log.info("方法耗时        : {} ms", (endTime - startTime));
        log.info("======= Controller 方法调用结束 =======\n");

        return result;
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
