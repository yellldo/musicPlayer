package com.music.player.framework.common.validation;

import cn.hutool.core.util.StrUtil;
import com.music.player.framework.common.utils.ValidationUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * ClassName : MobileValidator<br>
 * Description : 手机号校验实现<br>
 *
 * @author : sj
 * @date : 8/31/25
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {

    @Override
    public void initialize(Mobile constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // 如果手机号为空，默认不校验，即校验通过
        if (StrUtil.isEmpty(value)) {
            return true;
        }
        return ValidationUtils.isMobile(value);
    }
}
