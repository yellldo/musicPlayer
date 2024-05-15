package com.music.player.framework.mybatis.base.controller;

import com.music.player.framework.mybatis.base.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;

/**
 * ClassName : SuperSimpleController<br>
 * Description : 简单的实现了BaseController，为了获取注入 Service 和 实体类型<br>
 * <p>
 * 基类该类后，没有任何方法。 可以让业务Controller继承 SuperSimpleController 后，按需实现 *Controller 接口
 *
 * @author : sj
 * @date : 2024/5/5
 */
public class SuperSimpleController<S extends SuperService<Entity>, Entity> implements BaseController<Entity> {

    protected Class<Entity> entityClass = null;
    @Autowired
    protected S baseService;

    @Override
    public Class<Entity> getEntityClass() {
        if (entityClass == null) {
            this.entityClass = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        }
        return this.entityClass;
    }

    @Override
    public SuperService<Entity> getBaseService() {
        return baseService;
    }
}
