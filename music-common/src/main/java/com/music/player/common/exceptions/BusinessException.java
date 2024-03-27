package com.music.player.common.exceptions;

import com.music.player.common.domain.R;
import lombok.Getter;

/**
 * ClassName : BusinessException<br>
 * Description : BusinessException<br>
 *
 * @author : sj
 * @date : 2024/3/27
 */
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
