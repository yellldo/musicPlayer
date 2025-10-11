package com.music.player.user.enmus;

import com.music.player.framework.common.exception.IErrorCode;

/**
 * ClassName : ErrorCodeConstants<br>
 * Description : User 错误码枚举类<br>
 * <p>
 * User 系统，使用 1-003-000-000 段
 *
 * @author : sj
 * @date : 10/8/25
 */
public enum ErrorCodeConstants implements IErrorCode {


    USER_NOT_EXISTS(1_003_000_001, "用户不存在"),
    PHONE_CODE_EXISTS(1_003_000_002, "请勿重复发送手机验证，请稍后再试"),
    PHONE_CODE_EXPIRED(1_003_000_003, "手机验证码已过期或不存在，请重新发送"),
    PHONE_CODE_NOT_MATCH(1_003_000_004, "手机验证不匹配"),
    USER_STATUS_ERROR(1_003_000_005, "用户状态异常，请联系管理员"),
    USER_EXISTS(1_003_000_001, "用户已存在"),
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
