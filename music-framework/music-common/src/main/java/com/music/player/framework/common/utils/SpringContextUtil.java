package com.music.player.framework.common.utils;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ClassName : SpringContextUtil<br>
 * Description : SpringContextUtil<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return SpringContextUtil.applicationContext;
    }

    public static void publishEvent(Object event) {
        applicationContext.publishEvent(event);
    }
}
