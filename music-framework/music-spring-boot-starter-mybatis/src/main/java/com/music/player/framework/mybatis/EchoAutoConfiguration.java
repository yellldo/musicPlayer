package com.music.player.framework.mybatis;

import com.music.player.framework.mybatis.echo.core.EchoServiceImpl;
import com.music.player.framework.mybatis.echo.core.LoadService;
import com.music.player.framework.mybatis.echo.properties.EchoProperties;
import com.music.player.framework.mybatis.plugins.EchoDataInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Map;


/**
 * ClassName : EchoAutoConfiguration<br>
 * Description : 回显自动装配<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(EchoProperties.class)
public class EchoAutoConfiguration {

    private final EchoProperties echoProperties;

    @Bean
    @Lazy
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = EchoProperties.DATA_ECHO_PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
    public EchoServiceImpl echoService(Map<String, LoadService> loadServiceMap) {
        return new EchoServiceImpl(echoProperties, loadServiceMap);
    }

    @Bean
    public EchoDataInterceptor echoResultInterceptor(ApplicationContext applicationContext, EchoProperties echoProperties) {
        return new EchoDataInterceptor(applicationContext, echoProperties);
    }
}
