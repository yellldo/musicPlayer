package com.music.player.web.aop;

import com.music.player.framework.common.stopwatch.ConcurrentStopWatch;
import com.music.player.infra.api.service.log.SysLogServiceApi;
import com.music.player.web.annotation.LogRecord;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * ClassName : LogRecordInterceptor<br>
 * Description : LogRecordInterceptor<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@Slf4j
public class LogRecordInterceptor implements MethodInterceptor {

    @Autowired
    private SysLogServiceApi sysLogServiceApi;


    @Nullable
    @Override
    public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
        ConcurrentStopWatch concurrentStopWatch = new ConcurrentStopWatch();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURI();
        LogRecord logRecord = invocation.getMethod().getAnnotation(LogRecord.class);
        concurrentStopWatch.start(logRecord.value());
        Class<?> cls = AopProxyUtils.ultimateTargetClass(Objects.requireNonNull(invocation.getThis()));
        Object proceed = invocation.proceed();
        concurrentStopWatch.stop();
        if (!cls.equals(invocation.getThis().getClass())) {
            return proceed;
        }
        if (logRecord != null && logRecord.record()) {
            // insert log
        }
        log.info("{}: 执行:{} ms", url, concurrentStopWatch.totalTimeMillis());
        return proceed;
    }
}
