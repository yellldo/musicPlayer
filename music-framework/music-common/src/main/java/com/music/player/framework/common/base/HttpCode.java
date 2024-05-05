package com.music.player.framework.common.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * ClassName : HttpCode<br>
 * Description : API响应操作码<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
@Getter
@AllArgsConstructor
public enum HttpCode {

    /**
     * 成功
     */
    SUCCESS(HttpStatus.OK.value(), "请求成功"),

    /**
     * 业务异常
     */
    FAILURE(HttpStatus.INTERNAL_SERVER_ERROR.value(), "请求失败"),

    /**
     * 业务异常
     */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase()),
    ;

    final int code;

    final String message;
}
