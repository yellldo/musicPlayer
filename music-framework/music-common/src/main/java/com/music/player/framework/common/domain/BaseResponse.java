package com.music.player.framework.common.domain;

import cn.hutool.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : BaseResponse<br>
 * Description : BaseResponse<br>
 *
 * @author : sj
 * @date : 2024/3/18
 */
@ToString
@Setter
@Getter
public class BaseResponse {

    private String status = "0";
    private String message = "success";
    private int code = HttpStatus.HTTP_OK;

    public BaseResponse() {

    }

    public BaseResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(String status, String message, int code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
