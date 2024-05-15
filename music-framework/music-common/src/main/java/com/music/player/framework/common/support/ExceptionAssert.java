package com.music.player.framework.common.support;

import com.music.player.framework.common.support.code.IErrorCode;
import com.music.player.framework.common.support.code.ResultErrorCode;

/**
 * ClassName : ExceptionAssert<br>
 * Description : ExceptionAssert<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public class ExceptionAssert {

    public static void failure(String message) {
        throw new BizException(ResultErrorCode.FAILURE.getErrorCode(), message);
    }

    public static void failure(String code, String message) {
        throw new BizException(code, message);
    }

    public static void failure(IErrorCode errorCode) {
        throw new BizException(errorCode);
    }
}
