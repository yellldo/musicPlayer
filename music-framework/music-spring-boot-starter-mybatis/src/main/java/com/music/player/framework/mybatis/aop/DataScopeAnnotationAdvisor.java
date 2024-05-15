package com.music.player.framework.mybatis.aop;

import lombok.NonNull;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import java.lang.annotation.Annotation;

/**
 * ClassName : DataScopeAnnotationAdvisor<br>
 * Description : 多列数据权限aop通知<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
public class DataScopeAnnotationAdvisor extends AbstractPointcutAdvisor implements BeanFactoryAware {

    private final Advice advice;

    private final Pointcut pointcut;

    public DataScopeAnnotationAdvisor(@NonNull DataScopeInterceptor dataScopeInterceptor,
                                      Class<? extends Annotation> annotation,
                                      int order) {
        this.advice = dataScopeInterceptor;
        this.pointcut = AnnotationMatchingPointcut.forMethodAnnotation(annotation);
        setOrder(order);
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if (this.advice instanceof BeanFactoryAware) {
            ((BeanFactoryAware) this.advice).setBeanFactory(beanFactory);
        }
    }

}
