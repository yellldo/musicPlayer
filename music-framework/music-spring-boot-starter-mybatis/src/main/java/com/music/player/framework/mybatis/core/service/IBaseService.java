package com.music.player.framework.mybatis.core.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.QueryRequestParam;
import com.music.player.framework.common.base.SortingField;

import java.util.List;

/**
 * ClassName : IBaseService<br>
 * Description : IBaseService<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
public interface IBaseService<T> extends IService<T> {


    List<T> selectList(Wrapper<T> wrapper);

    List<T> selectList(List<SortingField> sortingFieldList, Wrapper<T> wrapper);

    PageResult<T> selectPage(QueryRequestParam queryRequestParam, Wrapper<T> wrapper);

    T selectOne(SFunction<T, ?> field, Object value);

    T selectOne(String field, Object value);

    T selectOne(SFunction<T, ?> field1, Object value1, SFunction<T, ?> field2, Object value2);

    T selectOne(SFunction<T, ?> field1, Object value1, SFunction<T, ?> field2, Object value2, SFunction<T, ?> field3, Object value3);

    long selectCount(Wrapper<T> wrapper);
}
