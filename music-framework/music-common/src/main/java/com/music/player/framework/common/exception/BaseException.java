package com.music.player.framework.common.exception;


/**
 * ClassName : BaseException<br>
 * Description : 基础异常类<br>
 *
 * @author : sj
 * @version : 1.0.0  sj 2021/2/16
 */
public interface BaseException {


    Integer getErrorCode();

    String getErrorMessage();

}
