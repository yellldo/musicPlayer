package com.music.player.framework.common.json.impl;

import com.music.player.framework.common.json.JSON;

import java.util.List;
import java.util.Map;

/**
 * ClassName : AbstractJSONImpl<br>
 * Description : AbstractJSONImpl<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public abstract class AbstractJSONImpl implements JSON {

    @Override
    public List<?> getList(Map<String, ?> obj, String key) {
        assert obj != null;
        assert key != null;
        if (!obj.containsKey(key)) {
            return null;
        }
        Object value = obj.get(key);
        if (!(value instanceof List)) {
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", value, key, obj));
        }
        return (List<?>) value;
    }
}
