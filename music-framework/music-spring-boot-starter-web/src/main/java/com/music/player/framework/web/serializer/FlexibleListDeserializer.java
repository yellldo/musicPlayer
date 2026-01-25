package com.music.player.framework.web.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName : FlexibleListDeserializer<br>
 * Description : FlexibleListDeserializer<br>
 *
 * @author : sj
 * @date : 1/24/26
 */
public class FlexibleListDeserializer extends JsonDeserializer<List<Long>> {

    @Override
    public List<Long> deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {

        JsonNode node = p.getCodec().readTree(p);
        List<Long> result = new ArrayList<>();

        if (node.isTextual()) {
            // 字符串
            String value = node.asText().trim();
            if (!value.isEmpty()) {
                String[] parts = value.split(",");
                for (String part : parts) {
                    try {
                        result.add(Long.valueOf(part.trim()));
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        } else if (node.isArray()) {
            // 数组
            for (JsonNode element : node) {
                if (element.isNumber()) {
                    result.add(element.asLong());
                } else if (element.isTextual()) {
                    try {
                        result.add(Long.valueOf(element.asText().trim()));
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        } else if (node.isNumber()) {
            // 单个数字
            result.add(node.asLong());
        }

        return result;
    }
}
