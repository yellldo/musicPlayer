package com.music.player.system.enmus;


import com.music.player.framework.common.exception.IErrorCode;

/**
 * ClassName : ErrorCodeConstants<br>
 * Description : ErrorCodeConstants<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
public enum ErrorCodeConstants implements IErrorCode {


    DICT_NOT_EXISTS(1_002_000_001, "配置不存在"),
    LOGIN_NAME_EXISTS(1_002_000_002, "账号已被使用"),
    USER_NOT_EXISTS(1_002_000_003, "用户不存在"),
    ROLE_NAME_EXISTS(1_002_000_003, "该角色已存在"),


    ;

    private final Integer code;
    private final String msg;


    ErrorCodeConstants(Integer code, String msg) {
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
