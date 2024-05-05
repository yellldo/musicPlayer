package com.music.player.framework.common.support;

/**
 * ClassName : BaseException<br>
 * Description : BaseException<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
public interface BaseException {

    /**
     * 返回异常信息
     *
     * @return String
     */
    String getErrorMsg();

    /**
     * 返回异常编码
     *
     * @return String
     */
    String getErrorCode();
}
