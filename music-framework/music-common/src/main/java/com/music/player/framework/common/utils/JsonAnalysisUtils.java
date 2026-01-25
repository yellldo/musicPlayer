package com.music.player.framework.common.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ClassName : JsonAnalysisUtils<br>
 * Description : JsonAnalysisUtils<br>
 *
 * @author : sj
 * @date : 1/24/26
 */
@Slf4j
public class JsonAnalysisUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        // 注册 Java 8 时间模块
        OBJECT_MAPPER.registerModule(new JavaTimeModule());

        // 禁用日期时间转换为时间戳
        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // 设置日期格式
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        // 配置其他选项
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    /**
     * 解析JSON到对象
     */
    public static <T> T parseToObject(String jsonStr, Class<T> clazz) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }

        try {
            return OBJECT_MAPPER.readValue(jsonStr, clazz);
        } catch (Exception e) {
            log.error("JSON解析失败: {}", jsonStr, e);
            throw new RuntimeException("JSON解析失败", e);
        }
    }

    /**
     * 更新对象的部分字段
     */
    public static <T> void updateObject(T target, String jsonStr, String... includeFields) {
        if (target == null || StringUtils.isBlank(jsonStr)) {
            return;
        }

        try {
            // 解析JSON为Map
            Map<String, Object> updates = OBJECT_MAPPER.readValue(jsonStr,
                    new TypeReference<>() {
                    });

            // 过滤字段
            if (includeFields != null && includeFields.length > 0) {
                Set<String> fieldSet = new HashSet<>(Arrays.asList(includeFields));
                updates.keySet().retainAll(fieldSet);
            }

            // 转换为目标对象类型
            Map<String, Object> targetMap = OBJECT_MAPPER.convertValue(target,
                    new TypeReference<>() {
                    });

            // 合并
            targetMap.putAll(updates);

            // 转换回对象
            T updated = OBJECT_MAPPER.convertValue(targetMap, (Class<T>) target.getClass());
            BeanUtils.copyProperties(updated, target);

        } catch (Exception e) {
            log.error("更新对象失败", e);
            throw new RuntimeException("更新对象失败", e);
        }
    }

    /**
     * 将JSON字段设置到对象的指定字段
     */
    public static void setFieldsFromJson(Object target, String jsonStr,
                                         Map<String, String> fieldMapping) {
        if (target == null || StringUtils.isBlank(jsonStr) || fieldMapping == null) {
            return;
        }

        try {
            JSONObject jsonObject = JSON.parseObject(jsonStr);
            BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(target);

            for (Map.Entry<String, String> entry : fieldMapping.entrySet()) {
                String jsonKey = entry.getKey();
                String beanProperty = entry.getValue();

                if (jsonObject.containsKey(jsonKey) && wrapper.isWritableProperty(beanProperty)) {
                    Object value = jsonObject.get(jsonKey);
                    Class<?> propertyType = wrapper.getPropertyType(beanProperty);
                    Object convertedValue = convertValue(value, propertyType);
                    wrapper.setPropertyValue(beanProperty, convertedValue);
                }
            }

        } catch (Exception e) {
            log.error("设置字段失败", e);
        }
    }

    private static Object convertValue(Object value, Class<?> targetType) {
        // 转换逻辑...
        return value;
    }
}
