package com.music.player.framework.id.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName : SnowflakeConfig<br>
 * Description : SnowflakeConfig<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "snowflake")
public class SnowflakeConfig {

    private Long workId;

    private Long datacenterId;
}
