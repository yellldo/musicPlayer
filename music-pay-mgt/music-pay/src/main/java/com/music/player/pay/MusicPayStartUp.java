package com.music.player.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName : MusicPayStartUp<br>
 * Description : MusicPayStartUp<br>
 *
 * @author : sj
 * @date : 2024/4/10
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.music.player.pay"})
@MapperScan("com.music.player.pay.mapper")
@EnableFeignClients
public class MusicPayStartUp {

    public static void main(String[] args) {
        SpringApplication.run(MusicPayStartUp.class, args);
    }
}
