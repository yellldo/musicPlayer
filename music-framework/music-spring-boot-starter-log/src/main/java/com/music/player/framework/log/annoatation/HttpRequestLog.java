package com.music.player.framework.log.annoatation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName : HttpRequestLog<br>
 * Description : 请求日志注解<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface HttpRequestLog {

    /**
     * 日志备注
     *
     * @return
     */
    String logRemark() default "";

    /**
     * 是否开启
     *
     * @return
     */
    boolean enabled() default true;

    /**
     * 是否记录请求入参
     *
     * @return
     */
    boolean recordRequest() default true;


}
