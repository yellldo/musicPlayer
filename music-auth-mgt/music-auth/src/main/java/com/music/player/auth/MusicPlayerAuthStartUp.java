package com.music.player.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName : MusicPlayerAuthStartUp<br>
 * Description : MusicPlayerAuthStartUp<br>
 *
 * @author : sj
 * @date : 2024/3/18
 */
@MapperScan(basePackages = "com.music.player.auth.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class MusicPlayerAuthStartUp {

    public static void main(String[] args) {
        SpringApplication.run(MusicPlayerAuthStartUp.class, args);
    }
}
