package com.music.player.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * ClassName : IdTypeEnvironmentPostProcessor<br>
 * Description : IdTypeEnvironmentPostProcessor<br>
 *
 * @author : sj
 * @date : 9/1/25
 */
@Slf4j
public class IdTypeEnvironmentPostProcessor implements EnvironmentPostProcessor {


    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

    }
}
