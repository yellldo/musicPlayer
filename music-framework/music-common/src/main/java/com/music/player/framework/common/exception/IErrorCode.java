package com.music.player.framework.common.exception;

/**
 * ClassName : IErrorCode<br>
 * Description : IErrorCode<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
public interface IErrorCode {

    /**
     * 获取错误码
     *
     * @return
     */
    Integer getErrorCode();

    /**
     * 获取错误描述
     *
     * @return
     */
    String getErrorMessage();
}
