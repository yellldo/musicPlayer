package com.music.player.framework.mybatis.core.query;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;


/**
 * ClassName : LambdaQueryWrapperX<br>
 * Description : LambdaQueryWrapperX<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
public class LambdaQueryWrapperX<T> extends LambdaQueryWrapper<T> {


    public LambdaQueryWrapperX<T> eqIfPresent(SFunction<T, ?> column, Object val) {
        if (ObjectUtil.isNotEmpty(val)) {
            return (LambdaQueryWrapperX<T>) super.eq(column, val);
        }

        return this;
    }


    public LambdaQueryWrapperX<T> likeIfPresent(SFunction<T, ?> column, Object val) {
        if (ObjectUtil.isNotEmpty(val)) {
            return (LambdaQueryWrapperX<T>) super.like(column, val);
        }

        return this;
    }
}
