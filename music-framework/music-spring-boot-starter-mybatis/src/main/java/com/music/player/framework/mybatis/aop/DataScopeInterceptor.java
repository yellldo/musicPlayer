package com.music.player.framework.mybatis.aop;

import com.music.player.framework.common.constant.BaseContextConstants;
import com.music.player.framework.common.context.RequestLocalContextHolder;
import com.music.player.framework.mybatis.annoatation.DataScope;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.lang.NonNull;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * ClassName : DataScopeInterceptor<br>
 * Description : 多列数据权限aop处理器<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
@Slf4j
public class DataScopeInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(@NonNull MethodInvocation invocation) throws Throwable {
        //fix 使用其他aop组件时,aop切了两次.
        Class<?> cls = AopProxyUtils.ultimateTargetClass(Objects.requireNonNull(invocation.getThis()));
        if (!cls.equals(invocation.getThis().getClass())) {
            return invocation.proceed();
        }
        Method method = invocation.getMethod();
        DataScope annotation = method.getAnnotation(DataScope.class);
        RequestLocalContextHolder.set(BaseContextConstants.MULTI_DATA_SCOPE, annotation);
        return invocation.proceed();
    }
}
