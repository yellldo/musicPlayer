package com.music.player.framework.common.exception.base;

import com.music.player.framework.common.exception.BaseException;
import com.music.player.framework.common.exception.IErrorCode;

/**
 * ClassName : BaseUnCheckException<br>
 * Description : 非运行期异常基类，所有自定义非运行时异常继承该类<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
public class BaseUnCheckException extends RuntimeException implements BaseException {

    /**
     * 异常信息
     */
    private String errorMsg;

    /**
     * 具体异常码
     */
    private Integer errorCode;


    public BaseUnCheckException(IErrorCode iErrorCode) {
        super(iErrorCode.getErrorMessage());
        this.errorCode = iErrorCode.getErrorCode();
        this.errorMsg = iErrorCode.getErrorMessage();
    }

    @Override
    public Integer getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMsg;
    }
}
