package com.music.player.framework.common.json.impl.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.music.player.framework.common.constant.enums.Enumerator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName : EnumSerializer<br>
 * Description : EnumSerializer<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public class EnumSerializer extends StdSerializer<Enumerator> {

    public final static EnumSerializer INSTANCE = new EnumSerializer();
    public final static String ALL_ENUM_KEY_FIELD = "code";
    public final static String ALL_ENUM_DESC_FIELD = "desc";

    public EnumSerializer() {
        super(Enumerator.class);
    }

    @Override
    public void serialize(Enumerator distance, JsonGenerator generator, SerializerProvider provider)
            throws IOException {
        Map<String, Object> enumeratorMap = new HashMap<>(2);
        enumeratorMap.put(ALL_ENUM_KEY_FIELD, distance.getCode());
        enumeratorMap.put(ALL_ENUM_DESC_FIELD, distance.getDesc());
        generator.writeObject(enumeratorMap);
    }
}
