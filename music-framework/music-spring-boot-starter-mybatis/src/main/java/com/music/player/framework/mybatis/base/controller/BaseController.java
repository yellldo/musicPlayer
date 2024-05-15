package com.music.player.framework.mybatis.base.controller;


import com.music.player.framework.mybatis.base.service.SuperService;

/**
 * ClassName : BaseController<br>
 * Description : 基础Controller<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public interface BaseController<Entity> {

    /**
     * 获取实体的类型
     *
     * @return Class<Entity>
     */
    Class<Entity> getEntityClass();

    /**
     * 获取Service
     *
     * @return SuperService<Entity>
     */
    SuperService<Entity> getBaseService();
}
