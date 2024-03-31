package com.music.player.auth.handler;

import com.music.player.common.domain.BaseResponse;
import com.music.player.common.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;

/**
 * ClassName : GlobalExceptionHandler<br>
 * Description : GlobalExceptionHandler<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@Slf4j
@ResponseBody
@ControllerAdvice("com.music.player")
public class GlobalExceptionHandler {

    /**
     * 通用错误状态
     */
    public static final String ERROR_STATUS = "500";

    @ExceptionHandler(value = Exception.class)
    public BaseResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new BaseResponse(ERROR_STATUS, e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(value = BusinessException.class)
    public BaseResponse handleBusinessException(BusinessException e) {
        log.error(e.getMessage(), e);
        return new BaseResponse(e.getErrorCode(), e.getMessage(), Integer.parseInt(e.getErrorCode()));
    }

    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e MethodArgumentNotValidException
     * @return R
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class, ConstraintViolationException.class})
    public R methodArgumentNotValidException(Exception e) {
        String message = "";
        if (e instanceof ConstraintViolationException) {
            ConstraintViolationException ce = (ConstraintViolationException) e;
            for (ConstraintViolation<?> messageInfo : ce.getConstraintViolations()) {
                message = messageInfo.getMessage();
            }
        } else {
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
        }
        log.error(message, e);
        return R.code(HttpStatus.BAD_REQUEST.value(), message);
    }

    @ExceptionHandler(BaseException.class)
    public BaseException baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        log.error(ex.getErrorMessage(), ex);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new BaseException(ex.getErrorMessage());
    }


    @ExceptionHandler(InvocationTargetException.class)
    public BaseException invocationTargetException(HttpServletResponse response, InvocationTargetException e) {
        log.error(e.getMessage(), e);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new BaseException(e.getMessage());
    }
}
