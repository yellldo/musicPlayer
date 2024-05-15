package com.music.player.framework.mybatis.echo.core;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * ClassName : LoadService<br>
 * Description : 加载数据<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public interface LoadService {

    /**
     * 根据id查询实体
     *
     * @param ids 唯一键（可能不是主键ID)
     * @return Map<Serializable, Object>
     */
    Map<Serializable, Object> findByIds(Set<Serializable> ids);

    /**
     * 根据id查询实体(分类过滤)
     *
     * @param ids 唯一键（可能不是主键ID)
     * @return Map<Serializable, Object>
     */
    Map<Serializable, Object> findByIdsAndFilter(Set<Serializable> ids);
}
