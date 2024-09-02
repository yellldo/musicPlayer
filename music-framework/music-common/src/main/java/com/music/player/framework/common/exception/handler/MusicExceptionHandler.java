package com.music.player.framework.common.exception.handler;

import cn.hutool.core.io.IORuntimeException;
import com.music.player.framework.common.base.BaseResponse;
import com.music.player.framework.common.base.HttpCode;
import com.music.player.framework.common.base.R;
import com.music.player.framework.common.support.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * ClassName: MusicExceptionHandler
 * Description:
 * Date:  2024/5/20 17:02
 *
 * @author zhaot
 */
@Slf4j
@ResponseBody
@ControllerAdvice("com.music.player")
public class MusicExceptionHandler {

    /**
     * 通用错误状态
     */
    public static final String ERROR_STATUS = "500";

    @ExceptionHandler(value = Exception.class)
    public BaseResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new BaseResponse(ERROR_STATUS, e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    /**
     * 自定义异常处理
     *
     * @param e -
     * @return -
     */
    @ExceptionHandler(BizException.class)
    public BaseResponse handleSystemException(BizException e) {
        log.error("exception occur!:", e);
        return new BaseResponse(ERROR_STATUS, e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    /**
     * IO异常
     *
     * @param e -
     * @return -
     */
    @ExceptionHandler(IORuntimeException.class)
    public R<?> handleIoException(IORuntimeException e) {
        log.error("exception occur!:", e);
        log.error(e.getMessage());
        return R.failed("网络错误！");
    }

    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e MethodArgumentNotValidException
     * @return R
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public BaseResponse methodArgumentNotValidException(Exception e) {
        String message = "";
        BindingResult bindingResult;
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            bindingResult = methodArgumentNotValidException.getBindingResult();
        } else {
            BindException bindException = (BindException) e;
            bindingResult = bindException.getBindingResult();
        }
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            message = fieldError.getDefaultMessage();
        }
        log.error(message, e);
        return new BaseResponse(HttpCode.FAILURE.getCode(), message);
    }
}
