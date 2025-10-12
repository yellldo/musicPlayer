package com.music.player.framework.mybatis.core.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.framework.common.base.QueryRequest;
import com.music.player.framework.common.base.SortingField;

import java.util.Collection;

/**
 * ClassName : MyBatisUtils<br>
 * Description : MyBatis 工具类<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
public class MyBatisUtils {

    public static <T> Page<T> buildPage(Wrapper<T> wrapper, QueryRequest queryRequest, Collection<SortingField> sortingFields) {
        // 页码 + 数量
        Page<T> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize());
        // 排序字段
        if (CollUtil.isNotEmpty(sortingFields)) {
            addOrder(wrapper, sortingFields);
        }
        return page;
    }


    @SuppressWarnings("PatternVariableCanBeUsed")
    public static <T> void addOrder(Wrapper<T> wrapper, Collection<SortingField> sortingFields) {
        if (CollUtil.isEmpty(sortingFields)) {
            return;
        }
        if (wrapper instanceof QueryWrapper<T>) {
            QueryWrapper<T> query = (QueryWrapper<T>) wrapper;
            for (SortingField sortingField : sortingFields) {
                query.orderBy(true,
                        SortingField.ORDER_ASC.equals(sortingField.getOrder()),
                        StrUtil.toUnderlineCase(sortingField.getField()));
            }
        } else if (wrapper instanceof LambdaQueryWrapper<T>) {
            // LambdaQueryWrapper 不直接支持字符串字段排序，使用 last 方法拼接 ORDER BY
            LambdaQueryWrapper<T> lambdaQuery = (LambdaQueryWrapper<T>) wrapper;
            StringBuilder orderBy = new StringBuilder();
            for (SortingField sortingField : sortingFields) {
                if (StrUtil.isNotEmpty(orderBy)) {
                    orderBy.append(", ");
                }
                orderBy.append(StrUtil.toUnderlineCase(sortingField.getField()))
                        .append(" ")
                        .append(SortingField.ORDER_ASC.equals(sortingField.getOrder()) ? "ASC" : "DESC");
            }
            lambdaQuery.last("ORDER BY " + orderBy);
            // 另外个思路：https://blog.csdn.net/m0_59084856/article/details/138450913
        } else {
            throw new IllegalArgumentException("Unsupported wrapper type: " + wrapper.getClass().getName());
        }

    }
}
