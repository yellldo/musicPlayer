package com.music.player.framework.common.json.impl.fastjson.serializer;

import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.music.player.framework.common.json.impl.fastjson.FastJsonSerializer;
import com.music.player.framework.common.json.impl.fastjson.codec.LocalDateCodec;
import com.music.player.spi.Join;

import java.time.LocalDate;

/**
 * ClassName : LocalDateJsonSerializer<br>
 * Description : LocalDateJsonSerializer<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Join
public class LocalDateJsonSerializer implements FastJsonSerializer<LocalDate> {

    @Override
    public Class<LocalDate> type() {
        return LocalDate.class;
    }

    @Override
    public ObjectSerializer serializer() {
        return LocalDateCodec.INSTANCE;
    }

    @Override
    public ObjectDeserializer deserializer() {
        return LocalDateCodec.INSTANCE;
    }
}
