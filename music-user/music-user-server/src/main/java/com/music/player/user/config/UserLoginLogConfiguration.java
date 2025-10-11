package com.music.player.user.config;


import com.music.player.user.biz.UserLoginLogBiz;
import com.music.player.user.dto.CreateUserLoginLogDto;
import com.music.player.user.event.UserLoginLogListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserLoginLogBiz userLoginLogBiz;

    @Bean
    @ConditionalOnMissingBean
    public UserLoginLogListener userLoginLogListener() {
        return new UserLoginLogListener(log -> {
            userLoginLogBiz.recordLoginLog((CreateUserLoginLogDto) log);
        });
    }
}
