package com.music.player.auth.api.enums;


import com.music.player.framework.common.exceptions.ErrorCode;

/**
 * ClassName : ErrorCodeConstants<br>
 * Description : 错误码枚举类<br>
 * <p>
 * auth，使用 1-001-000-000 段
 *
 * @author : sj
 * @date : 2024/3/31
 */
public interface ErrorCodeConstants {

    ErrorCode SYS_USER_NOT_EXISTS = new ErrorCode(1_001_000_001, "用户不存在");
    ErrorCode PHONE_NOT_EXISTS = new ErrorCode(1_001_000_002, "手机不存在");
    ErrorCode EMAIL_NOT_EXISTS = new ErrorCode(1_001_000_003, "邮箱不存在");
    ErrorCode USER_NOT_EXISTS = new ErrorCode(1_001_000_004, "用户不存在");
    ErrorCode PASSWORD_NOT_MATCH = new ErrorCode(1_001_000_005, "用户不存在");
}
