package com.music.player.framework.common.json.impl.jackson;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.music.player.spi.SPI;

/**
 * ClassName : JacksonSerializer<br>
 * Description : The interface Jackson serializer.<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@SPI
public interface JacksonSerializer<T> {

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
    JsonSerializer<T> serializer();

    /**
     * Jackson custom deserializer
     *
     * @return json deserializer
     */
    JsonDeserializer<? extends T> deserializer();
}
