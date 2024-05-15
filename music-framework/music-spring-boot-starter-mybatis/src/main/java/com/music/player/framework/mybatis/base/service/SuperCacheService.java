package com.music.player.framework.mybatis.base.service;

import java.io.Serializable;

/**
 * ClassName : SuperCacheService<br>
 * Description : 缓存父接口<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public interface SuperCacheService<T> extends SuperService<T> {

    /**
     * 查询缓存
     *
     * @param var1 id
     * @return T
     */
    T getByIdCache(Serializable var1);
}
