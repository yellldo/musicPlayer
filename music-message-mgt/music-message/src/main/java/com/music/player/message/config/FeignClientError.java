package com.music.player.message.config;

import com.google.gson.Gson;
import com.music.player.framework.common.exceptions.ServiceException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

/**
 * ClassName : FeignClientError<br>
 * Description : feign 异常处理<br>
 *
 * @author : sj
 * @date : 2024/4/6
 */
@Slf4j
@Configuration
public class FeignClientError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        log.info("{}", s);
        try {
            if (response.body() != null) {
                String errorContent = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
                Gson gson = new Gson();
                return gson.fromJson(errorContent, ServiceException.class);
            }
        } catch (Exception e) {
            log.error("FeignClientErrorDecoder decode exception:.", e);
            return e;
        }
        return new Exception("服务端未知异常！");
    }
}
