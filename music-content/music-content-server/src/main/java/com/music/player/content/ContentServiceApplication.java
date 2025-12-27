package com.music.player.content;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName : ContentServiceApplication<br>
 * Description : ContentServiceApplication<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.music.player", "com.music.player.framework.web"})
@MapperScan("com.music.player.content.mapper")
public class ContentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentServiceApplication.class, args);
    }
}
