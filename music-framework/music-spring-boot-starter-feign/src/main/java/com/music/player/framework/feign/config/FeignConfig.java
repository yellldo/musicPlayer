package com.music.player.framework.feign.config;

import com.music.player.framework.feign.decoder.CustomErrorDecoder;
import feign.Logger;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName : FeignConfig<br>
 * Description : FeignConfig<br>
 *
 * @author : sj
 * @date : 1/14/26
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, 1000, 3);
    }

    @Bean
    public ErrorDecoder customErrorDecoder() {
        return new CustomErrorDecoder();
    }
}
