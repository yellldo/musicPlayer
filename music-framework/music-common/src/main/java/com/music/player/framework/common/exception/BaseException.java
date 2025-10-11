package com.music.player.framework.common.exception;

import com.music.player.framework.common.base.R;
import com.music.player.framework.common.constants.CommonConstants;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName : BaseException<br>
 * Description : 基础异常类<br>
 *
 * @author : sj
 * @version : 1.0.0  sj 2021/2/16
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {

    private IErrorCode iErrorCode;

    private Integer errorCode;

    private String errorMessage;

    public BaseException(IErrorCode iErrorCode) {
        super(iErrorCode.getErrorMessage());
        this.iErrorCode = iErrorCode;
        this.errorCode = iErrorCode.getErrorCode();
        this.errorMessage = iErrorCode.getErrorMessage();
    }

    public BaseException(R r) {
        super(r.getMsg());
        this.setErrorCode(r.getCode());
        this.setErrorMessage(r.getMsg());
    }

    public BaseException(String message) {
        super(message);
        this.setErrorCode(CommonConstants.FAIL);
        this.setErrorMessage(message);
    }
}
