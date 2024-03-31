package com.music.player.auth.config;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * ClassName : FeignErrorDecoder<br>
 * Description : FeignErrorDecoder<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@Configuration
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        String msg = null;
        try {
            msg = Util.toString(response.body().asReader());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 抛出自定义的业务异常
        throw new BusinessException(msg);
    }
}
