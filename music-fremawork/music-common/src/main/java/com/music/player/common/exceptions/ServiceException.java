package com.music.player.common.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName : ServiceException<br>
 * Description : 业务逻辑异常 Exception<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {

    /**
     * 业务错误码
     *
     * @see com.music.player.common.exceptions.enums.ServiceErrorCodeRange
     */
    private Integer code;
    /**
     * 错误提示
     */
    private String message;

    /**
     * 空构造方法，避免反序列化问题
     */
    public ServiceException() {
    }

    public ServiceException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public ServiceException setCode(Integer code) {
        this.code = code;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ServiceException setMessage(String message) {
        this.message = message;
        return this;
    }
}
