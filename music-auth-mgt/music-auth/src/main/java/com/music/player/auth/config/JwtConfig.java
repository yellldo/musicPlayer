package com.music.player.auth.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName : JwtConfig<br>
 * Description : JwtConfig<br>
 *
 * @author : sj
 * @date : 2024/3/30
 */
@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private String header;

    private String secret;

    private Long expiration;

    private String onlineKey;

    private String codeKey;
}
