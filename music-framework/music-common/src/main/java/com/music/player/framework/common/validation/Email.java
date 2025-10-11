package com.music.player.framework.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * ClassName : Email<br>
 * Description : Email校验注解<br>
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
        validatedBy = EmailValidator.class
)
public @interface Email {

    String message() default "邮箱格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
