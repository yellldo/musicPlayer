package com.music.player.framework.id;

import cn.hutool.core.lang.Snowflake;
import com.music.player.framework.id.service.IdGeneratorService;
import com.music.player.framework.id.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName : MusicIdGeneratorConfiguration<br>
 * Description : MusicIdGeneratorConfiguration<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Slf4j
@AutoConfiguration
public class MusicIdGeneratorConfiguration implements WebMvcConfigurer {

    @Bean
    @ConditionalOnProperties({
            @ConditionalOnProperty(name = "snowflake.work-id"),
            @ConditionalOnProperty(name = "snowflake.datacenter-id")
    })
    public Snowflake snowflake() {
        return new Snowflake();
    }

    @Bean
    @ConditionalOnProperties({
            @ConditionalOnProperty(name = "snowflake.work-id"),
            @ConditionalOnProperty(name = "snowflake.datacenter-id")
    })
    public IdGeneratorService idGeneratorService() {
        return new IdGeneratorService();
    }

    @Bean
    public IdUtils idUtils() {
        return new IdUtils();
    }


}
