package com.music.player.common.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : ErrorCode<br>
 * Description : 错误码对象<br>
 *
 * @author : sj
 * @date : 2024/3/31
 * <p>
 * TODO TODO 错误码设计成对象的原因，为未来的 i18 国际化做准备
 */
@Setter
@Getter
@ToString
public class ErrorCode {


    /**
     * 错误码
     */
    private final Integer code;
    /**
     * 错误提示
     */
    private final String msg;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }
}
