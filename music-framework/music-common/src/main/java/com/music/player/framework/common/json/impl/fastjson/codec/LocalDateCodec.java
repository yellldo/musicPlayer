package com.music.player.framework.common.json.impl.fastjson.codec;

import cn.hutool.core.date.DatePattern;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * ClassName : LocalDateCodec<br>
 * Description : fastjson LocalDateCodec<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public class LocalDateCodec implements ObjectSerializer, ObjectDeserializer {

    public static final LocalDateCodec INSTANCE = new LocalDateCodec(DatePattern.NORM_DATE_PATTERN);
    private final String pattern;

    public LocalDateCodec(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.out;
        if (object == null) {
            out.writeNull();
        } else {
            LocalDate result = (LocalDate) object;
            out.writeString(result.format(DateTimeFormatter.ofPattern(pattern)));
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        String date = parser.parseObject(String.class, fieldName);
        return (T) LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
