package com.music.player.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName : MusicPlayerMessageStartUp<br>
 * Description : MusicPlayerMessageStartUp<br>
 *
 * @author : sj
 * @date : 2024/4/3
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.music.player.message"})
@MapperScan("com.music.player.message.mapper")
@EnableFeignClients({"com.music.player.auth.api"})
public class MusicPlayerMessageStartUp {

    public static void main(String[] args) {
        SpringApplication.run(MusicPlayerMessageStartUp.class, args);
    }
}



