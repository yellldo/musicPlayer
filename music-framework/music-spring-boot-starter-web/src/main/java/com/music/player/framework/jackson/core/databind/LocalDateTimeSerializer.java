package com.music.player.framework.jackson.core.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * ClassName : LocalDateTimeSerializer<br>
 * Description : LocalDateTime序列化规则
 * 会将LocalDateTime序列化为毫秒级时间戳<br>
 *
 * @author : sj
 * @date : 2024/4/1
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    public static final LocalDateTimeSerializer INSTANCE = new LocalDateTimeSerializer();

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(value.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }
}
