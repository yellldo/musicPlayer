package com.music.player.framework.common.json.impl.fastjson.serializer;

import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.music.player.framework.common.json.impl.fastjson.FastJsonSerializer;
import com.music.player.framework.common.json.impl.fastjson.codec.LocalTimeCodec;
import com.music.player.spi.Join;

import java.time.LocalTime;

/**
 * ClassName : LocalTimeJsonSerializer<br>
 * Description : LocalTimeJsonSerializer<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Join
public class LocalTimeJsonSerializer implements FastJsonSerializer<LocalTime> {

    @Override
    public Class<LocalTime> type() {
        return LocalTime.class;
    }

    @Override
    public ObjectSerializer serializer() {
        return LocalTimeCodec.INSTANCE;
    }

    @Override
    public ObjectDeserializer deserializer() {
        return LocalTimeCodec.INSTANCE;
    }
}
