package com.music.player.framework.common.exception.base;

import com.music.player.framework.common.exception.IErrorCode;
import lombok.Getter;

import java.io.Serial;

/**
 * ClassName : BusinessException<br>
 * Description : BusinessException<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Getter
public class BusinessException extends BaseUnCheckException {


    @Serial
    private static final long serialVersionUID = -2048152732013177744L;

    public BusinessException(IErrorCode iErrorCode) {
        super(iErrorCode);
    }


}
