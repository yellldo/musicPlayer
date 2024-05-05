package com.music.player.framework.common.json.impl.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.music.player.framework.common.constant.enums.Enumerator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName : EnumeratorSerializer<br>
 * Description : 枚举序列化类<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public class EnumeratorSerializer extends JsonSerializer<Enumerator> {

    @Override
    public void serialize(Enumerator enumerator, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        Map<String, Object> enumeratorMap = new HashMap<>(2);
        enumeratorMap.put("code", enumerator.getCode());
        enumeratorMap.put("desc", enumerator.getDesc());
        jsonGenerator.writeObject(enumeratorMap);
    }
}
