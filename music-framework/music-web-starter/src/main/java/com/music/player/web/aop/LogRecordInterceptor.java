package com.music.player.web.aop;

import cn.hutool.core.util.URLUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import com.music.player.framework.common.spring.SpringContextUtils;
import com.music.player.framework.common.stopwatch.ConcurrentStopWatch;
import com.music.player.framework.common.util.SpringContextHolder;
import com.music.player.infra.api.service.log.SysLogServiceApi;
import com.music.player.web.annotation.LogRecord;
import com.music.player.web.config.MusicLogProperties;
import com.music.player.web.event.SysLogEventSource;
import com.music.player.web.utils.LogTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
        Object proceed = null;
        LogRecord logRecord = invocation.getMethod().getAnnotation(LogRecord.class);
        concurrentStopWatch.start(logRecord.value());
        SysLogEventSource logVo = new SysLogEventSource();
        try {
            Class<?> cls = AopProxyUtils.ultimateTargetClass(Objects.requireNonNull(invocation.getThis()));
            proceed = invocation.proceed();
            concurrentStopWatch.stop();
            log.info("{}: 执行:{} ms", url, concurrentStopWatch.totalTimeMillis());
            if (!cls.equals(invocation.getThis().getClass())) {
                return proceed;
            }
        } catch (Exception e) {
            // 这里一定要抛出去，不然会把所有异常都吞掉什么都看不到！！！！！
            e.printStackTrace();
        } finally {
            if (logRecord != null && logRecord.record()) {
                // 异步日志
                SpringContextUtils.publishEvent(logVo);
            }
        }
        return proceed;
    }

    public SysLogEventSource getSysLog() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        SysLogEventSource sysLog = new SysLogEventSource();
        sysLog.setLogType(LogTypeEnum.NORMAL.getType());
        sysLog.setRequestUri(URLUtil.getPath(request.getRequestURI()));
        sysLog.setMethod(request.getMethod());
        sysLog.setRemoteAddr(ServletUtil.getClientIP(request));
//        sysLog.setServiceId(getClientId());

        // get 参数脱敏
        MusicLogProperties logProperties = SpringContextHolder.getBean(MusicLogProperties.class);
//        Map<String, String[]> paramsMap = MapUtil.removeAny(request.getParameterMap(),
//                ArrayUtil.toArray(logProperties.getExcludeFields(), String.class));
        sysLog.setParams(HttpUtil.toParams(request.getParameterMap()));
        return sysLog;
    }
}
