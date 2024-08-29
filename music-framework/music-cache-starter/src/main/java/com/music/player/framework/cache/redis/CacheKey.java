package com.music.player.framework.cache.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.Duration;

/**
 * ClassName : CacheKey<br>
 * Description : 缓存 key 封装<br>
 *
 * @author : sj
 * @date : 2024/8/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CacheKey {


    /**
     * redis key
     */
    @NonNull
    private String key;
    /**
     * 超时时间 秒
     */
    private Duration expire;

    public CacheKey(final @NonNull String key) {
        this.key = key;
    }
}
