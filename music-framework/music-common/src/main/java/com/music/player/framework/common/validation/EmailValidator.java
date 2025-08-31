package com.music.player.framework.common.validation;

import cn.hutool.core.util.StrUtil;
import com.music.player.framework.common.utils.ValidationUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * ClassName : EmailValidator<br>
 * Description : Email校验具体实现<br>
 *
 * @author : sj
 * @date : 8/31/25
 */
public class EmailValidator implements ConstraintValidator<Email, String> {

    @Override
    public void initialize(Email constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // 如果邮箱为空，默认不校验，即校验通过
        if (StrUtil.isEmpty(value)) {
            return true;
        }
        return ValidationUtils.isEmail(value);
    }
}
