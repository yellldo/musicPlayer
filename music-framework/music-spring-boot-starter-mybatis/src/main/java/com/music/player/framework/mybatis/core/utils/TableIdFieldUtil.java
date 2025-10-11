package com.music.player.framework.mybatis.core.utils;

import com.baomidou.mybatisplus.annotation.TableId;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

/**
 * ClassName : TableIdFieldUtil<br>
 * Description : TableIdFieldUtil<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
public class TableIdFieldUtil {

    /**
     * 获取实体类中带有 @TableId 注解的字段
     */
    public static Optional<Field> getTableIdField(Class<?> entityClass) {
        // 获取所有声明的字段（包括 private，不包括父类字段）
        return Arrays.stream(entityClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(TableId.class))
                .findFirst();
    }
}
