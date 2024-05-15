package com.music.player.framework.mybatis.mybatis.injector;

import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.music.player.framework.mybatis.constant.EntityConstant;
import com.music.player.framework.mybatis.mybatis.method.UpdateAllById;

import java.util.List;

/**
 * ClassName : BaseSqlInjector<br>
 * Description : 自定义Sql注入<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public class BaseSqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        /*
          以下 3 个为内置选装件
          头 2 个支持字段筛选函数
         */
        // 例: 不要指定了 update 填充的字段
        methodList.add(new InsertBatchSomeColumn(i -> i.getFieldFill() != FieldFill.UPDATE));
        methodList.add(new AlwaysUpdateSomeColumnById());
        methodList.add(new UpdateAllById(field -> !ArrayUtil.containsAny(new String[]{
                EntityConstant.CREATED_AT_FIELD, EntityConstant.CREATED_BY_FIELD}, field.getColumn())));
        return methodList;
    }
}
