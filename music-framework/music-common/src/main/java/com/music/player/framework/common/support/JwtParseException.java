package com.music.player.framework.common.support;

import com.music.player.framework.common.support.code.ResultErrorCode;
import lombok.Getter;

/**
 * ClassName : JwtParseException<br>
 * Description : jwt解析异常类<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Getter
public class JwtParseException extends BaseUncheckedException {

    private static final long serialVersionUID = 6898087804057803400L;

    public JwtParseException() {
        super(ResultErrorCode.JSON_TRANSFORM_ERROR);
    }

    public JwtParseException(String errorMsg) {
        super(ResultErrorCode.JSON_TRANSFORM_ERROR.getErrorCode(), errorMsg);
    }


    public JwtParseException(String message,
                             Throwable cause) {
        super(ResultErrorCode.JSON_TRANSFORM_ERROR.getErrorCode(), message, cause);
    }
}
