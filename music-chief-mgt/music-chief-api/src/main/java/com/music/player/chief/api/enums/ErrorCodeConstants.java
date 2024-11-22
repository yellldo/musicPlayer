package com.music.player.chief.api.enums;

import com.music.player.framework.common.support.code.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeConstants implements IErrorCode {

    AUTHOR_NOT_EXISTS("2-002-000-001", "用户不存在"),

    MUSIC_APPLY_NOT_EXISTS("2-002-000-002", "音乐申请信息不存在"),

    ;


    final String errorCode;

    final String errorMsg;
}
