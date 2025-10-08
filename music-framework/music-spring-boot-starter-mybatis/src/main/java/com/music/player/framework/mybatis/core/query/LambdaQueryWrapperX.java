package com.music.player.framework.mybatis.core.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.util.Objects;

/**
 * ClassName : LambdaQueryWrapperX<br>
 * Description : LambdaQueryWrapperX<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
public class LambdaQueryWrapperX<T> extends LambdaQueryWrapper<T> {


    public LambdaQueryWrapperX<T> eqIfPresent(SFunction<T, ?> column, Object val) {
        if (Objects.nonNull(val)) {
            return (LambdaQueryWrapperX<T>) super.eq(column, val);
        }

        return this;
    }
}
