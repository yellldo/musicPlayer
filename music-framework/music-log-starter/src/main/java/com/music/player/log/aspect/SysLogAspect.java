package com.music.player.log.aspect;

import cn.hutool.core.util.StrUtil;
import com.music.player.framework.common.stopwatch.ConcurrentStopWatch;
import com.music.player.framework.common.util.SpringContextHolder;
import com.music.player.log.annotation.SysLog;
import com.music.player.log.event.SysLogEvent;
import com.music.player.log.event.SysLogEventSource;
import com.music.player.log.utils.LogTypeEnum;
import com.music.player.log.utils.SysLogUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.expression.EvaluationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName : SysLogAspect<br>
 * Description : 操作日志使用spring event异步入库<br>
 *
 * @author : sj
 * @date : 2024/5/16
 */
@Aspect
@Slf4j
@RequiredArgsConstructor
public class SysLogAspect {

    @Around("@annotation(sysLog)")
    @SneakyThrows
    public Object around(ProceedingJoinPoint point, SysLog sysLog) {
        long totalTimeMillis;
        String value = sysLog.value();
        ConcurrentStopWatch concurrentStopWatch = new ConcurrentStopWatch();
        concurrentStopWatch.start(value);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURI();
        String expression = sysLog.expression();
        // 当前表达式存在 SPEL，会覆盖 value 的值
        if (StrUtil.isNotBlank(expression)) {
            // 解析SPEL
            MethodSignature signature = (MethodSignature) point.getSignature();
            EvaluationContext context = SysLogUtils.getContext(point.getArgs(), signature.getMethod());
            try {
                value = SysLogUtils.getValue(context, expression, String.class);
            } catch (Exception e) {
                // SPEL 表达式异常，获取 value 的值
                log.error("@SysLog 解析SPEL {} 异常", expression);
            }
        }

        SysLogEventSource logVo = SysLogUtils.getSysLog();
        logVo.setTitle(value);
        // 获取请求body参数
        if (StrUtil.isBlank(logVo.getParams())) {
            logVo.setBody(point.getArgs());
        }
        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        Object obj;

        try {
            obj = point.proceed();
            concurrentStopWatch.stop();
            totalTimeMillis = concurrentStopWatch.totalTimeMillis();
            log.info("{}: 执行:{} ms", url, totalTimeMillis);
        } catch (Exception e) {
            logVo.setLogType(LogTypeEnum.ERROR.getType());
            logVo.setException(e.getMessage());
            throw e;
        } finally {
            Long endTime = System.currentTimeMillis();
            logVo.setTime(endTime - startTime);
            SpringContextHolder.publishEvent(new SysLogEvent(logVo));
        }

        return obj;
    }
}
