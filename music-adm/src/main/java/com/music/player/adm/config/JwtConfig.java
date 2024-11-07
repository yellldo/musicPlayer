package com.music.player.adm.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

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
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private String header;

    private String secret;

    private Long expiration;

    private String onlineKey;

    private String codeKey;
}
