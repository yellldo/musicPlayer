package com.music.player.message.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "spring.mail")
public class MailConfig {

    private String userName;

    private String host;

    private String password;

}
