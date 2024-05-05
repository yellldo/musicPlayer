package com.music.player.framework.common.support.code;

/**
 * ClassName : IErrorCode<br>
 * Description : 封装异常状态码<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
public interface IErrorCode {

    /**
     * code
     *
     * @return String
     */
    String getErrorCode();

    /**
     * getMessage
     *
     * @return String
     */
    String getErrorMsg();
}
