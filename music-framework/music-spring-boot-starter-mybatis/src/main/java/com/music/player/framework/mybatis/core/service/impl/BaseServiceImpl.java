package com.music.player.framework.mybatis.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.ISqlSegment;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.QueryRequestParam;
import com.music.player.framework.common.base.SortingField;
import com.music.player.framework.mybatis.core.mapper.CommonMapper;
import com.music.player.framework.mybatis.core.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    private Wrapper<T> wrapper;

    @Override
    public List<T> selectList(Wrapper<T> wrapper) {
        return selectList(null, wrapper);
    }

    @Override
    public List<T> selectList(List<SortingField> sortingFieldList, Wrapper<T> wrapper) {
        LambdaQueryWrapper<T> queryWrapper = (LambdaQueryWrapper<T>) wrapper;
        if (sortingFieldList != null && !sortingFieldList.isEmpty()) {
            MergeSegments expression = queryWrapper.getExpression();
            for (SortingField sortingField : sortingFieldList) {
                SqlKeyword mode = sortingField.getOrder().equals(SqlKeyword.ASC.getSqlSegment()) ? SqlKeyword.ASC : SqlKeyword.DESC;
                expression.add(SqlKeyword.ORDER_BY, sortingField::getField, mode);
            }
        }
        return mapper.selectList(queryWrapper);
    }

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

    @Override
    public long selectCount(Wrapper<T> wrapper) {
        return mapper.selectCount(wrapper);
    }


}
