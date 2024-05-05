package com.music.player.framework.common.json.impl.fastjson.serializer;

import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.music.player.framework.common.json.impl.fastjson.FastJsonSerializer;
import com.music.player.framework.common.json.impl.fastjson.codec.LocalDateTimeCodec;
import com.music.player.spi.Join;

import java.time.LocalDateTime;

/**
 * ClassName : LocalDateTimeJsonSerializer<br>
 * Description : LocalDateTimeJsonSerializer<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Join
public class LocalDateTimeJsonSerializer implements FastJsonSerializer<LocalDateTime> {

    @Override
    public Class<LocalDateTime> type() {
        return LocalDateTime.class;
    }

    @Override
    public ObjectSerializer serializer() {
        return LocalDateTimeCodec.INSTANCE;
    }

    @Override
    public ObjectDeserializer deserializer() {
        return LocalDateTimeCodec.INSTANCE;
    }
}
