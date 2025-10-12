package com.music.player.user.config;


import com.music.player.framework.common.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName : UserLoginLogConfiguration<br>
 * Description : UserLoginLogConfiguration<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Slf4j
@Configuration
public class UserLoginLogConfiguration {


    @Bean
    @ConditionalOnMissingBean
    public SpringContextUtil springContextUtil() {
        return new SpringContextUtil();
    }

}
