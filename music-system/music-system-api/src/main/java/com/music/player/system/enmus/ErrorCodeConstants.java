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
    ROLE_NAME_EXISTS(1_002_000_004, "该角色已存在"),
    ROLE_NAME_USED(1_002_000_005, "角色名称已存在"),
    USER_STATUS_ABNORMAL(1_002_000_006, "用户状态异常，请联系管理员"),
    PASSWORD_ERROR(1_002_000_007, "密码错误"),
    DICT_TYPE_EXISTS(1_002_000_008, "字典类型已存在"),
    DICT_LABEL_EXISTS(1_002_000_008, "字典项已存在"),

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
