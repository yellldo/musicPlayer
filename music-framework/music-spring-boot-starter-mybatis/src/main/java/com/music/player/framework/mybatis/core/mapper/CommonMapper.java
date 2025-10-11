package com.music.player.framework.mybatis.core.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseMapper;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.QueryRequest;
import com.music.player.framework.common.base.QueryRequestParam;
import com.music.player.framework.common.base.SortingField;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.music.player.framework.mybatis.core.utils.MyBatisUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName : BaseMapperX<br>
 * Description : 在 MyBatis Plus 的 BaseMapper 的基础上拓展，提供更多的能力<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
public interface CommonMapper<T> extends MPJBaseMapper<T> {


    default PageResult<T> selectPage(QueryRequestParam queryRequestParam, Wrapper<T> wrapper) {
        return selectPage(queryRequestParam, queryRequestParam.getSortingFields(), wrapper);
    }

    default PageResult<T> selectPage(QueryRequest queryRequest, @Param("ew") Wrapper<T> wrapper) {
        return selectPage(queryRequest, null, wrapper);
    }

    default PageResult<T> selectPage(QueryRequest queryRequest, List<SortingField> sortingFieldList, Wrapper<T> wrapper) {

        // 不分页
        if (QueryRequest.PAGE_SIZE_NONE.equals(queryRequest.getPageSize())) {
            MyBatisUtils.addOrder(wrapper, sortingFieldList);
            List<T> list = selectList(wrapper);
            return new PageResult<>(list, (long) list.size());
        }

        // MyBatis Plus 查询
        IPage<T> page = MyBatisUtils.buildPage(queryRequest, sortingFieldList);
        selectPage(page, wrapper);
        return new PageResult<>(page.getRecords(), page.getTotal());
    }

    default T selectOne(SFunction<T, ?> field, Object value) {
        return selectOne(new LambdaQueryWrapper<T>().eq(field, value));
    }

    default T selectOne(String field, Object value) {
        return selectOne(new QueryWrapper<T>().eq(field, value));
    }

    default T selectOne(SFunction<T, ?> field1, Object value1, SFunction<T, ?> field2, Object value2) {
        return selectOne(new LambdaQueryWrapper<T>().eq(field1, value1).eq(field2, value2));
    }

    default T selectOne(SFunction<T, ?> field1, Object value1, SFunction<T, ?> field2, Object value2, SFunction<T, ?> field3, Object value3) {
        return selectOne(new LambdaQueryWrapper<T>().eq(field1, value1).eq(field2, value2).eq(field3, value3));
    }
}
