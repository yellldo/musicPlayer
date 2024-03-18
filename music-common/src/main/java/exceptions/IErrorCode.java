package exceptions;

/**
 * ClassName : IErrorCode<br>
 * Description : 错误码接口抽象，供枚举实现来做全局异常统一处理使用<br>
 *
 * @author : sj
 * @date : 2024/3/18
 */
public interface IErrorCode {

    /**
     * 获取错误码
     *
     * @return
     */
    String getErrorCode();

    /**
     * 获取错误描述
     *
     * @return
     */
    String getErrorMessage();
}
