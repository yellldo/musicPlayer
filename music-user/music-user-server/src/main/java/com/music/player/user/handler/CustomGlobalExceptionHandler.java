package com.music.player.user.handler;

import cn.dev33.satoken.exception.NotLoginException;
import com.music.player.framework.common.base.R;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : CustomGlobalExceptionHandler<br>
 * Description : CustomGlobalExceptionHandler<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@ControllerAdvice
@RestController
@Slf4j
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(value = NotLoginException.class)
    public R<?> notLoginException(HttpServletResponse response, NotLoginException ex) {
        log.error(ex.getMessage(), ex);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return R.failed(ex.getCode(), ex.getMessage());
    }

}
