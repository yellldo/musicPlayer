package com.music.player.framework.common.json.impl.fastjson;

import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

/**
 * ClassName : FastJsonSerializer<br>
 * Description : FastJsonSerializer<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */

public interface FastJsonSerializer<T> {

    /**
     * jackson serializer class type.
     *
     * @return class
     */
    Class<T> type();

    /**
     * Jackson custom serializer
     *
     * @return json serializer
     */
    ObjectSerializer serializer();

    /**
     * Jackson custom deserializer
     *
     * @return json deserializer
     */
    ObjectDeserializer deserializer();
}
