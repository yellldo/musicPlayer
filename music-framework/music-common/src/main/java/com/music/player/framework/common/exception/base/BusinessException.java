package com.music.player.framework.common.exception.base;

import com.music.player.framework.common.base.R;
import com.music.player.framework.common.exception.BaseException;
import com.music.player.framework.common.exception.IErrorCode;
import lombok.Getter;

/**
 * ClassName : BusinessException<br>
 * Description : BusinessException<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Getter
public class BusinessException extends BaseException {

    @Getter
    private String[] args;

    public BusinessException(IErrorCode iErrorCode) {
        super(iErrorCode);
    }

    public BusinessException(IErrorCode iErrorCode, String... args) {
        super(iErrorCode);
        this.args = args;
    }

    public BusinessException(R r) {
        super(r);
    }

    public BusinessException(String message) {
        super(message);
    }
}
