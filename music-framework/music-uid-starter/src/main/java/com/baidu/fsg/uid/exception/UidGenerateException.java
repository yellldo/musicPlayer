package com.baidu.fsg.uid.exception;

/**
 * ClassName : UidGenerateException<br>
 * Description : UidGenerateException<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
public class UidGenerateException extends RuntimeException {

    public UidGenerateException() {
        super();
    }

    public UidGenerateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UidGenerateException(String message) {
        super(message);
    }

    public UidGenerateException(String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
    }


    public UidGenerateException(Throwable cause) {
        super(cause);
    }
}
