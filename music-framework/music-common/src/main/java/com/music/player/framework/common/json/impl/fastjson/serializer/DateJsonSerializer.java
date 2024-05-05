package com.music.player.framework.common.json.impl.fastjson.serializer;

import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.music.player.framework.common.json.impl.fastjson.FastJsonSerializer;
import com.music.player.framework.common.json.impl.fastjson.codec.DateCodec;
import com.music.player.spi.Join;

import java.util.Date;

/**
 * ClassName : DateJsonSerializer<br>
 * Description : DateJsonSerializer<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Join
public class DateJsonSerializer implements FastJsonSerializer<Date> {

    @Override
    public Class<Date> type() {
        return Date.class;
    }

    @Override
    public ObjectSerializer serializer() {
        return DateCodec.INSTANCE;
    }

    @Override
    public ObjectDeserializer deserializer() {
        return DateCodec.INSTANCE;
    }
}
