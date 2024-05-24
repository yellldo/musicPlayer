package com.music.player.framework.common.base;

import com.music.player.framework.common.constant.CommonConstants;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ClassName : R<br>
 * Description : web接口响应结果<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {

    private static final long serialVersionUID = -720885758850999950L;

    private int code;

    private String msg;

    private T data;

    public static <T> R<T> ok() {
        return restResult(null, CommonConstants.SUCCESS, null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, CommonConstants.SUCCESS, "操作成功");
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, CommonConstants.SUCCESS, msg);
    }

    public static <T> R<T> success() {
        return restResult(null, CommonConstants.SUCCESS, "操作成功");
    }

    public static <T> R<T> failed() {
        return restResult(null, CommonConstants.FAIL, null);
    }

    public static <T> R<T> failed(String msg) {
        return restResult(null, CommonConstants.FAIL, msg);
    }

    public static <T> R<T> failed(T data) {
        return restResult(data, CommonConstants.FAIL, null);
    }

    public static <T> R<T> failed(T data, String msg) {
        return restResult(data, CommonConstants.FAIL, msg);
    }

    public static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

}
