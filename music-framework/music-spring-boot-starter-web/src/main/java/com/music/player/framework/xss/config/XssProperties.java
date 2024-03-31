package com.music.player.framework.xss.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;

/**
 * ClassName : XssProperties<br>
 * Description : Xss 配置属性<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@ConfigurationProperties(prefix = "music.xss")
@Validated
@Setter
@Getter
public class XssProperties {

    /**
     * 是否开启，默认为 true
     */
    private boolean enable = true;
    /**
     * 需要排除的 URL，默认为空
     */
    private List<String> excludeUrls = Collections.emptyList();
}
