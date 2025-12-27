package com.music.player.framework.web.annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * ClassName : LogPrint<br>
 * Description : LogPrint<br>
 *
 * @author : sj
 * @date : 10/30/25
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface LogPrint {

    boolean enable() default true;

    String module() default "";

    String operation() default "";
}
