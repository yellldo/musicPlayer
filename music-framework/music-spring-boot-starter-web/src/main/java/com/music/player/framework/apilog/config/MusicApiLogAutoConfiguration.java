package com.music.player.framework.apilog.config;

import com.music.player.framework.apilog.core.service.ApiAccessLogFrameworkService;
import com.music.player.framework.apilog.core.service.ApiAccessLogFrameworkServiceImpl;
import com.music.player.framework.web.config.MusicWebConfiguration;
import com.music.player.infra.api.service.ApiAccessLogFeign;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName : MusicApiLogAutoConfiguration<br>
 * Description : MusicApiLogAutoConfiguration<br>
 *
 * @author : sj
 * @date : 2024/4/6
 */
@AutoConfigureAfter(value = MusicWebConfiguration.class)
public class MusicApiLogAutoConfiguration implements WebMvcConfigurer {

    @Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public ApiAccessLogFrameworkService apiAccessLogFrameworkService(ApiAccessLogFeign apiAccessLogFeign) {
        return new ApiAccessLogFrameworkServiceImpl(apiAccessLogFeign);
    }


}
