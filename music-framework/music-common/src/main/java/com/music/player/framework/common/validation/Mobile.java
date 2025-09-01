package com.music.player.framework.common.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * ClassName : Mobile<br>
 * Description : 手机号校验注解<br>
 *
 * @author : sj
 * @date : 8/31/25
 */
@Target({
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.CONSTRUCTOR,
        ElementType.TYPE_USE,
        ElementType.ANNOTATION_TYPE,
        ElementType.PARAMETER
})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = MobileValidator.class
)
public @interface Mobile {

    String message() default "手机号格式不正确";
}
