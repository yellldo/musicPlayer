package com.music.player.log;

import com.music.player.log.aspect.SysLogAspect;
import com.music.player.log.config.MusicLogProperties;
import com.music.player.log.event.SysLogListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * ClassName : LogAutoConfiguration<br>
 * Description : LogAutoConfiguration<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
@EnableAsync
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(MusicLogProperties.class)
@ConditionalOnProperty(value = "security.log.enabled", matchIfMissing = true)
public class LogAutoConfiguration {

//    @Bean
//    public SysLogListener sysLogListener(MusicLogProperties logProperties, RemoteLogService remoteLogService) {
//        return new SysLogListener(remoteLogService, logProperties);
//    }

    @Bean
    public SysLogAspect sysLogAspect() {
        return new SysLogAspect();
    }
}
