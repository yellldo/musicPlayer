package com.music.player.framework.common.support;

import cn.hutool.core.util.StrUtil;
import com.music.player.framework.common.support.code.IErrorCode;
import com.music.player.framework.common.util.StrPool;

/**
 * ClassName : BaseUncheckedException<br>
 * Description : 非运行期异常基类，所有自定义非运行时异常继承该类<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
public class BaseUncheckedException extends RuntimeException implements BaseException {

    private static final long serialVersionUID = 6352083473955354303L;

    /**
     * 异常信息
     */
    private String errorMsg;

    /**
     * 具体异常码
     */
    private String errorCode;

    public BaseUncheckedException(IErrorCode errorCode) {
        this.errorCode = errorCode.getErrorCode();
        this.errorMsg = errorCode.getErrorMsg();
    }

    public BaseUncheckedException(Throwable cause) {
        super(cause);
    }

    public BaseUncheckedException(final String errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }


    public BaseUncheckedException(final String errorCode, final String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BaseUncheckedException(final String errorCode,
                                  final String errorMsg,
                                  Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BaseUncheckedException(final String errorCode, final String format, Object... args) {
        super(StrUtil.contains(format, StrPool.BRACE) ?
                StrUtil.format(format, args) :
                String.format(format, args));
        this.errorCode = errorCode;
        this.errorMsg = StrUtil.contains(format, StrPool.BRACE) ?
                StrUtil.format(format, args) :
                String.format(format, args);
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }
}
