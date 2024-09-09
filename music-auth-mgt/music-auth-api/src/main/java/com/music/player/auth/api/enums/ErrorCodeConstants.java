package com.music.player.auth.api.enums;


import com.music.player.framework.common.support.code.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName : ErrorCodeConstants<br>
 * Description : 错误码枚举类<br>
 * <p>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeConstants implements IErrorCode {

    SYS_USER_NOT_EXISTS("1-002-000-000", "用户不存在"),
    PHONE_NOT_EXISTS("1-002-000-001", "手机号不存在"),
    EMAIL_NOT_EXISTS("1-002-000-002", "邮箱不存在"),
    PASSWORD_NOT_MATCH("1-002-000-003", "密码错误"),
    USER_NOT_EXISTS("1-002-000-004", "用户不存在"),

    SYS_USER_EXISTS("1-002-000-005", "用户已存在"),
    PHONE_EXISTS("1-002-000-006", "手机号已存在"),
    EMAIL_EXISTS("1-002-000-007", "邮箱已存在"),
    USER_EXISTS("1-002-000-008", "用户已存在"),
    SYS_USER_LOGIN_FAIL("1-002-000-008", "登录失败，账号或密码错误"),
    ;

    final String errorCode;

    final String errorMsg;
}

