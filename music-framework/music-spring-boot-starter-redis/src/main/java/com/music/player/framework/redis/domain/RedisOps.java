package com.music.player.framework.redis.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.*;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * ClassName : RedisOps<br>
 * Description : RedisOps<br>
 *
 * @author : sj
 * @date : 10/9/25
 */
@Slf4j
@Getter
public class RedisOps {


    private final RedisTemplate<String, Object> redisTemplate;
    private final StringRedisTemplate stringRedisTemplate;
    private final ValueOperations<String, Object> valueOps;
    private final HashOperations<String, Object, Object> hashOps;
    private final ListOperations<String, Object> listOps;
    private final SetOperations<String, Object> setOps;
    private final ZSetOperations<String, Object> zSetOps;
    private final StreamOperations<String, Object, Object> streamOps;


    public RedisOps(RedisTemplate<String, Object> redisTemplate, StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = redisTemplate;
        this.valueOps = redisTemplate.opsForValue();
        this.hashOps = redisTemplate.opsForHash();
        this.listOps = redisTemplate.opsForList();
        this.setOps = redisTemplate.opsForSet();
        this.zSetOps = redisTemplate.opsForZSet();
        this.streamOps = redisTemplate.opsForStream();
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 检查value是否为null
     *
     * @param value
     * @param <T>
     * @return
     */
    public static <T> boolean isNullValue(T value) {
        boolean isNull = value == null || NullValue.class.equals(value.getClass());
        return isNull || value.getClass().equals(Object.class) || (value instanceof Map && ((Map<?, ?>) value).isEmpty());
    }

    /**
     * 返回
     *
     * @param value
     * @param <T>
     * @return
     */
    public <T> T returnValue(T value) {
        return isNullValue(value) ? null : value;
    }

    /**
     * new 一个空值
     *
     * @return 空对象
     */
    private NullValue newNullVal() {
        return new NullValue();
    }


    /**
     *
     * 返回与键 key 相关联的 value 值
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> T get(@NonNull String key, boolean cacheNullValue) {
        T value = (T) valueOps.get(key);
        if (cacheNullValue && value == null) {
            set(key, newNullVal(), true);
        }
        return returnValue(value);
    }

    /**
     * 将值 value 存放到 key
     * <p>
     * 如果存在key，那就覆盖
     * 之前设置的生存时间（TTL），也会被重置
     *
     * @param key            key，一定不能为空
     * @param value          值
     * @param cacheNullValue 是否缓存null对象
     */
    public void set(@NonNull String key, Object value, boolean cacheNullValue) {
        if (!cacheNullValue && value == null) {
            return;
        }
        valueOps.set(key, value == null ? new NullValue() : value);
    }

    public void set(@NonNull String key, Object value, long seconds, boolean cacheNullValue) {
        if (!cacheNullValue && value == null) {
            return;
        }
        valueOps.set(key, value == null ? new NullValue() : value, seconds, TimeUnit.SECONDS);
    }

    public void del(String key) {
        if (!StringUtils.hasLength(key)) {
            log.warn("key为空，不进行删除操作");
            return;
        }
        redisTemplate.delete(key);
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public Boolean exists(@NonNull String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 给key设置生存时间（TTL），key过期时会被删除
     *
     * @param key
     * @param seconds
     */
    public Boolean expire(@NonNull String key, long seconds) {
        return redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    public Boolean expire(@NonNull String key, Duration timeout) {
        return expire(key, timeout.getSeconds());
    }

}
