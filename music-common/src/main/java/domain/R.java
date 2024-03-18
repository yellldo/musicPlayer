package domain;

import lombok.ToString;

/**
 * ClassName : R<br>
 * Description : 统一返回的报文格式 <br>
 *
 * @author : sj
 * @date : 2024/3/18
 */
@ToString
public class R<T> extends BaseResponse {

    private T data;

    public R(String status, String message) {
        super(status, message);
    }

    public R() {

    }

    public static R ok(Object data) {
        return new R<Object>().data(data);
    }

    public static R ok() {
        return new R<Object>();
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public R data(T data) {
        this.setData(data);
        return this;
    }

    public static R code(int code, String message) {
        R<Object> r = new R<>();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }
}

