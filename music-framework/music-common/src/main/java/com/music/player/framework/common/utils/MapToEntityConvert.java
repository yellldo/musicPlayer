package com.music.player.framework.common.utils;


import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

/**
 * ClassName : MapToEntityConvert<br>
 * Description : MapToEntityConvert<br>
 *
 * @author : sj
 * @date : 10/15/25
 */
public class MapToEntityConvert {


    public static <T> T mapToEntity(LinkedHashMap<String, Object> map, Class<T> clazz) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        T entity = clazz.getDeclaredConstructor().newInstance(); // 创建实体类实例
        BeanUtils.copyProperties(entity, map); // 使用map填充实体类的属性
        return entity;
    }
}
