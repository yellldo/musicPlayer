package com.music.player.framework.common.exception.enums;

import com.music.player.framework.common.exception.IErrorCode;

/**
 * ClassName : GlobalErrorCodeConstants<br>
 * Description : 全局异常码<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
public enum GlobalErrorCodeConstants implements IErrorCode {

    PARAM_ERROR(1_000_000_001, "参数异常"),
    SERVER_NOT_AVAILABLE(1_000_000_002,"服务暂时不可用"),


    ;

    private final Integer code;
    private final String msg;


    GlobalErrorCodeConstants(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getErrorCode() {
        return this.code;
    }

    @Override
    public String getErrorMessage() {
        return this.msg;
    }
}


