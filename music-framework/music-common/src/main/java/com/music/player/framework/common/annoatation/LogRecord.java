package com.music.player.framework.common.annoatation;

import java.lang.annotation.*;

/**
 * ClassName : LogRecord<br>
 * Description : 日志记录注解<br>
 *
 * @author : sj
 * @date 2024/3/18
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRecord {

    /**
     * 是否开启 默认开启
     */
    boolean record() default true;

    /**
     * 名称
     */
    String value() default "";

    /**
     * 类型
     */
    String type() default "";
}
