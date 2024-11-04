package com.music.player.chief;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName : MusicChiefStartUp<br>
 * Description : MusicChiefStartUp<br>
 *
 * @author : sj
 * @date : 2024/10/14
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = "com.music.player.auth.mapper")
public class MusicChiefStartUp {

    public static void main(String[] args) {
        SpringApplication.run(MusicChiefStartUp.class, args);
    }
}
