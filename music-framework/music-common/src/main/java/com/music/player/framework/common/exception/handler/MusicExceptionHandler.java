package com.music.player.framework.common.exception.handler;

import cn.hutool.core.io.IORuntimeException;
import com.music.player.framework.common.base.R;
import com.music.player.framework.common.support.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * ClassName: MusicExceptionHandler
 * Description:
 * Date:  2024/5/20 17:02
 *
 * @author zhaot
 */
@Slf4j
@RestControllerAdvice
public class MusicExceptionHandler {

    /**
     * 自定义异常处理
     * @param e -
     * @return -
     */
    @ExceptionHandler(BizException.class)
    public R<?> handleSystemException(BizException e) {
        log.error("exception occur!:", e);
        log.error(e.getMessage());
        return R.failed(e.getMessage());
    }

    /**
     * IO异常
     * @param e -
     * @return -
     */
    @ExceptionHandler(IORuntimeException.class)
    public R<?> handleIoException(IORuntimeException e) {
        log.error("exception occur!:", e);
        log.error(e.getMessage());
        return R.failed("网络错误！");
    }
}
