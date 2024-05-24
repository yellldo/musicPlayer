package com.music.player.framework.common.support;

import com.music.player.framework.common.support.code.IErrorCode;
import com.music.player.framework.common.support.code.ResultErrorCode;
import lombok.Getter;

/**
 * ClassName : BizException<br>
 * Description : 业务异常类<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Getter
public class BizException extends BaseUncheckedException {

    private static final long serialVersionUID = -3238517855583910821L;


    public BizException(IErrorCode errorCode) {
        super(errorCode.getErrorCode(), errorCode.getErrorMsg());
    }

    public BizException(IErrorCode errorCode, String errorMsg) {
        super(errorCode.getErrorCode(), errorMsg);
    }

    public BizException(String code, String message) {
        super(code, message);
    }

    public BizException(String message) {
        super(ResultErrorCode.COMMON_FAILURE.getErrorCode(), message);
    }
}
