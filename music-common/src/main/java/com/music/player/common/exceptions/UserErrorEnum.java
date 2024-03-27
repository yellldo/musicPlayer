package com.music.player.common.exceptions;

/**
 * ClassName : UserErrorEnum<br>
 * Description : UserErrorEnum<br>
 *
 * @author : sj
 * @date : 2024/3/27
 */
public enum UserErrorEnum implements IErrorCode {

    PHONE_EXIST("-2"),
    EMAIL_EXIST("-3"),
    USER_NOT_EXISTS("-4"),
    PASSWORD_NOT_MATCH("-5"),

    ;
    private String code;

    UserErrorEnum(final String code) {
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
