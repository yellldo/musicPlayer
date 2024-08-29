package com.music.player.framework.cache.service.impl;

import com.music.player.framework.cache.redis.CacheHashKey;
import com.music.player.framework.cache.redis.CacheKey;
import com.music.player.framework.cache.redis.RedisOps;
import com.music.player.framework.cache.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * ClassName : RedisCacheServiceImpl<br>
 * Description : redis缓存提供接口实现类<br>
 *
 * @author : sj
 * @date : 2024/8/29
 */
@Slf4j
public class RedisCacheServiceImpl implements CacheService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final RedisOps redisOps;
    private final ValueOperations<String, Object> valueOperations;

    public RedisCacheServiceImpl(RedisTemplate<String, Object> redisTemplate, RedisOps redisOps) {
        this.redisTemplate = redisTemplate;
        this.redisOps = redisOps;
        valueOperations = redisTemplate.opsForValue();
    }


    @Override
    public <T> T get(String key) {
        return null;
    }

    @Override
    public <T> T get(String key, Function<String, T> function) {
        return null;
    }

    @Override
    public <T, M> T get(String key, Function<M, T> function, M funcParam) {
        return null;
    }

    @Override
    public <T> T get(String key, Function<String, T> function, Duration timeout) {
        return null;
    }

    @Override
    public <T, M> T get(String key, Function<M, T> function, M funcParam, Duration timeout) {
        return null;
    }

    @Override
    public void set(String key, Object obj) {

    }

    @Override
    public void set(String key, Object value, Duration timeout) {

    }

    @Override
    public boolean setIfAbsent(String key, Object value, Duration timeout) {
        return false;
    }

    @Override
    public boolean setIfAbsent(String key, Object value) {
        return false;
    }

    @Override
    public Long increment(String key) {
        return null;
    }

    @Override
    public Long increment(String key, long delta) {
        return null;
    }

    @Override
    public Long decrement(String key) {
        return null;
    }

    @Override
    public Long decrement(String key, long delta) {
        return null;
    }

    @Override
    public void remove(String... keys) {

    }

    @Override
    public boolean exists(String key) {
        return false;
    }

    @Override
    public void flushDb() {

    }

    @Override
    public Set<String> keys(String pattern) {
        return null;
    }

    @Override
    public List<String> scan(String pattern) {
        return null;
    }

    @Override
    public void scanUnlink(String pattern) {

    }

    @Override
    public Boolean expire(CacheKey key) {
        return null;
    }

    @Override
    public Boolean persist(CacheKey key) {
        return null;
    }

    @Override
    public String type(CacheKey key) {
        return null;
    }

    @Override
    public Long ttl(CacheKey key) {
        return null;
    }

    @Override
    public Long pTtl(CacheKey key) {
        return null;
    }

    @Override
    public void hSet(CacheHashKey key, Object value, boolean... cacheNullValues) {

    }

    @Override
    public <T> T hGet(CacheHashKey key, boolean... cacheNullValues) {
        return null;
    }

    @Override
    public <T> T hGet(CacheHashKey key, Function<CacheHashKey, T> loader, boolean... cacheNullValues) {
        return null;
    }

    @Override
    public Boolean hExists(CacheHashKey cacheHashKey) {
        return null;
    }

    @Override
    public Long hDel(String key, Object... fields) {
        return null;
    }

    @Override
    public Long hDel(CacheHashKey cacheHashKey) {
        return null;
    }

    @Override
    public Long hLen(CacheHashKey key) {
        return null;
    }

    @Override
    public Long hIncrBy(CacheHashKey key, long increment) {
        return null;
    }

    @Override
    public Double hIncrBy(CacheHashKey key, double increment) {
        return null;
    }

    @Override
    public Set<Object> hKeys(CacheHashKey key) {
        return null;
    }

    @Override
    public List<Object> hVals(CacheHashKey key) {
        return null;
    }

    @Override
    public <K, V> Map<K, V> hGetAll(CacheHashKey key) {
        return null;
    }

    @Override
    public <K, V> Map<K, V> hGetAll(CacheHashKey key, Function<CacheHashKey, Map<K, V>> loader, boolean... cacheNullValues) {
        return null;
    }

    @Override
    public Long sAdd(CacheKey key, Object value) {
        return null;
    }

    @Override
    public Long sRem(CacheKey key, Object... members) {
        return null;
    }

    @Override
    public Set<Object> sMembers(CacheKey key) {
        return null;
    }

    @Override
    public <T> T sPop(CacheKey key) {
        return null;
    }

    @Override
    public Long sCard(CacheKey key) {
        return null;
    }
}
