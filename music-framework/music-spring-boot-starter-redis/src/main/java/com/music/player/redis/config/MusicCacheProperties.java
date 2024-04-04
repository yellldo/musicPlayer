package com.music.player.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * ClassName : MusicCacheProperties<br>
 * Description : MusicCacheProperties<br>
 *
 * @author : sj
 * @date : 2024/4/4
 */
@ConfigurationProperties("music.cache")
@Data
@Validated
public class MusicCacheProperties {

    /**
     * {@link #redisScanBatchSize} 默认值
     */
    private static final Integer REDIS_SCAN_BATCH_SIZE_DEFAULT = 30;

    /**
     * redis scan 一次返回数量
     */
    private Integer redisScanBatchSize = REDIS_SCAN_BATCH_SIZE_DEFAULT;
}
