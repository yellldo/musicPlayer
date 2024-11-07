package com.music.player.adm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.music.player.adm.mapper")
@EnableFeignClients(basePackages = {"com.music.player.auth", "com.music.player.chief"})
public class MusicAdmStartUp {

    public static void main(String[] args) {
        SpringApplication.run(MusicAdmStartUp.class);
    }
}
