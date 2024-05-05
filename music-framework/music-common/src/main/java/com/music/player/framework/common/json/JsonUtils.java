package com.music.player.framework.common.json;

import com.music.player.framework.common.json.impl.fastjson.FastJsonImpl;
import com.music.player.framework.common.json.impl.gson.GsonImpl;
import com.music.player.framework.common.json.impl.jackson.JacksonImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName : JsonUtils<br>
 * Description : JsonUtils<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public class JsonUtils {

    static String PREFER_JSON_FRAMEWORK_NAME = "spring.json-framework.prefer";

    private static volatile JSON json;

    public static JSON getJson() {
        if (json == null) {
            synchronized (JsonUtils.class) {
                if (json == null) {
                    String preferJsonFrameworkName = System.getProperty(PREFER_JSON_FRAMEWORK_NAME);
                    if (StringUtils.isNotEmpty(preferJsonFrameworkName)) {
                        try {
                            JSON instance = null;
                            switch (preferJsonFrameworkName) {
                                case "fastjson":
                                    instance = new FastJsonImpl();
                                    break;
                                case "jackson":
                                    instance = new JacksonImpl();
                                    break;
                                case "gson":
                                    instance = new GsonImpl();
                                    break;
                                default:
                                    break;
                            }
                            if (instance != null && instance.isSupport()) {
                                json = instance;
                            }
                        } catch (Throwable ignore) {
                            ignore.printStackTrace();
                        }
                    }
                    if (json == null) {
                        List<Class<? extends JSON>> jsonClasses = Arrays.asList(
                                JacksonImpl.class,
                                FastJsonImpl.class,
                                GsonImpl.class);
                        for (Class<? extends JSON> jsonClass : jsonClasses) {
                            try {
                                JSON instance = jsonClass.getConstructor().newInstance();
                                if (instance.isSupport()) {
                                    json = instance;
                                    break;
                                }
                            } catch (Throwable ignore) {

                            }
                        }
                    }
                    if (json == null) {
                        throw new IllegalStateException("Dubbo unable to find out any json framework (e.g. fastjson, gson) from jvm env. " +
                                "Please import at least one json framework.");
                    }
                }
            }
        }
        return json;
    }
}
