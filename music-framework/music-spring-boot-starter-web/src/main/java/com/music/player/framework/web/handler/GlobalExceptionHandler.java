package com.music.player.framework.web.handler;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.music.player.framework.common.base.HttpCode;
import com.music.player.framework.common.base.R;
import com.music.player.framework.common.exception.BaseException;
import com.music.player.framework.common.exception.base.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName : GlobalExceptionHandler<br>
 * Description : 全局异常处理器，将 Exception 翻译成 R + 对应的异常编号<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@Slf4j
@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final String applicationName;


    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param ex MethodArgumentNotValidException
     * @return R
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public R<?> methodArgumentNotValidExceptionHandler(HttpServletRequest request, Throwable ex) {

        // 获取所有校验错误
        var errors = ((MethodArgumentNotValidException) ex).getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> Map.of(
                        "field", error.getField(),           // 字段名，如 "name"
                        "message", error.getDefaultMessage() // 错误提示，如 "不能为空"
                ))
                .collect(Collectors.toList());

        return R.failed(errors);
    }

    @ExceptionHandler(BusinessException.class)
    public R<?> businessExceptionHandler(HttpServletResponse response, BaseException ex) {
        log.error(ex.getErrorMessage(), ex);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return R.failed(ex.getErrorCode(), ex.getErrorMessage());
    }

    @ExceptionHandler(BaseException.class)
    public R<?> baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        log.error(ex.getErrorMessage(), ex);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return R.failed(ex.getErrorCode(), ex.getErrorMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public R<?> defaultExceptionHandler(HttpServletRequest request, Throwable ex) {

        log.error("[defaultExceptionHandler]", ex);
        // 特殊：如果是 BaseException 的异常，则直接返回
        if (ex.getCause() != null && ex.getCause() instanceof BaseException) {

        }


        // 插入异常日志
        createExceptionLog(request, ex);
        // 返回 failed R
        return R.failed(HttpCode.FAILURE, HttpCode.FAILURE.getMessage());
    }

    public void createExceptionLog(HttpServletRequest request, Throwable e) {

        buildExceptionLog(request, e);

    }


    public void buildExceptionLog(HttpServletRequest request, Throwable e) {

    }


    public R<?> handleTableNotExists(Throwable ex) {
        String message = ExceptionUtil.getRootCauseMessage(ex);
        if (!message.contains("doesn't exist")) {
            return null;
        }

        return null;
    }
}
