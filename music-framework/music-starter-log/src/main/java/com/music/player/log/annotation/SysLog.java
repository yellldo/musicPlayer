package com.music.player.log.annotation;

import java.lang.annotation.*;

/**
 * ClassName : SysLog<br>
 * Description : 操作日志注解<br>
 *
 * @author : sj
 * @date : 2024/5/16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**
     * 描述
     *
     * @return {String}
     */
    String value() default "";

    /**
     * spel 表达式
     *
     * @return 日志描述
     */
    String expression() default "";
}
