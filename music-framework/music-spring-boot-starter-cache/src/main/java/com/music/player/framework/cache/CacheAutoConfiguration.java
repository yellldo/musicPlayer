package com.music.player.framework.cache;


import com.music.player.framework.cache.service.CacheService;
import com.music.player.framework.cache.service.CaffeineCacheImpl;
import com.music.player.framework.cache.support.CacheExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

/**
 * ClassName : CacheAutoConfiguration<br>
 * Description : 缓存自动配置类<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Configuration
@Import({CacheExceptionHandler.class})
public class CacheAutoConfiguration {

    @Bean
    @Lazy
    public CacheService cacheCaffeineTemplate() {
        return new CaffeineCacheImpl();
    }
}
