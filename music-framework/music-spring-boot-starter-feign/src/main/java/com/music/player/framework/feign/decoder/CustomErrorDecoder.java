package com.music.player.framework.feign.decoder;

import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.common.exception.enums.GlobalErrorCodeConstants;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * ClassName : CustomErrorDecoder<br>
 * Description : 自定义错误解码器<br>
 *
 * @author : sj
 * @date : 1/14/26
 */
@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {


    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            String errorBody = Util.toString(response.body().asReader(Charset.defaultCharset()));
            log.error("Feign调用失败，method={}, status={}, body={}",
                    methodKey, response.status(), errorBody);

            if (response.status() >= 500) {
                return new BusinessException(GlobalErrorCodeConstants.SERVER_NOT_AVAILABLE);
            } else if (response.status() == 400) {
                return new BusinessException(GlobalErrorCodeConstants.PARAM_ERROR);
            }
        } catch (IOException e) {
            log.error("解析Feign错误响应失败", e);
        }

        return new RuntimeException("Feign调用失败: " + response.status());
    }

}
