package com.music.player.common.exceptions;

/**
 * ClassName : SysErrorEnum<br>
 * Description : 系统异常枚举<br>
 *
 * @author : sj
 * @date : 2024/3/18
 */
public enum SysErrorEnum implements IErrorCode {

    /**
     * 未知错误
     */
    UNKNOWN_ERROR("-1"),
    VALIDATION_ERROR("-11"),
    ;
    private String code;

    SysErrorEnum(final String code) {
        this.code = code;
    }


    @Override
    public String getErrorCode() {
        return this.code;
    }

    @Override
    public String getErrorMessage() {
        return this.code;
    }
}
