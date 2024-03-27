package com.music.player.common.exceptions;

import com.music.player.common.domain.R;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : BaseException<br>
 * Description : BaseException<br>
 *
 * @author : sj
 * @date : 2024/3/18
 */
@Setter
@Getter
@ToString
public class BaseException extends RuntimeException {

    private IErrorCode iErrorCode;

    private String errorCode;

    private String errorMessage;

    public BaseException(IErrorCode iErrorCode) {
        super(iErrorCode.getErrorMessage());
        this.iErrorCode = iErrorCode;
        this.errorCode = iErrorCode.getErrorCode();
        this.errorMessage = iErrorCode.getErrorMessage();
    }

    public BaseException(R r) {
        super();
        this.setErrorCode(r.getStatus());
        this.setErrorMessage(r.getMessage());
    }

    public BaseException(String message) {
        super(message);
        this.setErrorCode("500");
        this.setErrorMessage(message);
    }
}
