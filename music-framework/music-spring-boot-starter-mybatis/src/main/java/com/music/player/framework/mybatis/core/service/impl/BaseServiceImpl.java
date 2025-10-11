package com.music.player.framework.mybatis.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.QueryRequestParam;
import com.music.player.framework.mybatis.core.mapper.CommonMapper;
import com.music.player.framework.mybatis.core.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName : BaseServiceImpl<br>
 * Description : BaseServiceImpl<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
public class BaseServiceImpl<M extends CommonMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {

    @Autowired
    private M mapper;

    @Override
    public PageResult<T> selectPage(QueryRequestParam queryRequestParam, Wrapper<T> wrapper) {
        return mapper.selectPage(queryRequestParam, queryRequestParam.getSortingFields(), wrapper);
    }

    @Override
    public T selectOne(SFunction<T, ?> field, Object value) {
        return mapper.selectOne(field, value);
    }

    @Override
    public T selectOne(String field, Object value) {
        return mapper.selectOne(field, value);
    }

    @Override
    public T selectOne(SFunction<T, ?> field1, Object value1, SFunction<T, ?> field2, Object value2) {
        return mapper.selectOne(field1, value1, field2, value2);
    }

    @Override
    public T selectOne(SFunction<T, ?> field1, Object value1, SFunction<T, ?> field2, Object value2, SFunction<T, ?> field3, Object value3) {
        return mapper.selectOne(field1, value1, field2, value2, field3, value3);
    }


}
