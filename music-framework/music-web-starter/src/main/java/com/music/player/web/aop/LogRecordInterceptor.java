package com.music.player.web.aop;

import com.music.player.framework.common.stopwatch.ConcurrentStopWatch;
import com.music.player.framework.common.util.IpUtil;
import com.music.player.infra.api.service.log.SysLogServiceApi;
import com.music.player.infra.api.service.log.dto.SaveSysLogDto;
import com.music.player.web.annotation.LogRecord;
import com.music.player.web.event.SysLogEvent;
import com.music.player.web.publisher.SysLogPublisher;
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
    @Autowired
    private SysLogPublisher sysLogPublisher;


    @Nullable
    @Override
    public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
        ConcurrentStopWatch concurrentStopWatch = new ConcurrentStopWatch();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURI();
        Object proceed = null;
        LogRecord logRecord = invocation.getMethod().getAnnotation(LogRecord.class);
        concurrentStopWatch.start(logRecord.value());
        SaveSysLogDto saveSysLogDto = new SaveSysLogDto().setRequestUri(url).setMethod(request.getMethod()).setIp(IpUtil.getIpAddr(request));
        try {
            // TODO 获取入参
//            saveSysLogDto.setParams(request.getParameterMap());
            Class<?> cls = AopProxyUtils.ultimateTargetClass(Objects.requireNonNull(invocation.getThis()));
            proceed = invocation.proceed();
            concurrentStopWatch.stop();
            log.info("{}: 执行:{} ms", url, concurrentStopWatch.totalTimeMillis());
            if (!cls.equals(invocation.getThis().getClass())) {
                return proceed;
            }
        } catch (Exception e) {
            concurrentStopWatch.stop();
            saveSysLogDto.setException(e.getMessage());
            // 这里一定要抛出去，不然会把所有异常都吞掉什么都看不到！！！！！
            throw e;
        } finally {
            saveSysLogDto.setTime(concurrentStopWatch.totalTimeMillis());
            sysLogPublisher.publish(new SysLogEvent("保存日志", saveSysLogDto));
        }
        return proceed;
    }


}
