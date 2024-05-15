package com.music.player.framework.mybatis.base.controller;

import com.music.player.framework.mybatis.base.service.SuperCacheService;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * ClassName : SuperCacheController<br>
 * Description : super 缓存controller<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public class SuperCacheController<S extends SuperCacheService<Entity>, Id extends Serializable, Entity, SaveDTO, UpdateDTO, QueryDTO, ExcelEntity>
        extends SuperController<S, Id, Entity, SaveDTO, UpdateDTO, QueryDTO, ExcelEntity> {


    /**
     * 查询
     *
     * @param id 主键id
     * @return 查询结果
     */
    @Override
    public Entity get(@PathVariable Id id) {
        return baseService.getByIdCache(id);
    }
}
