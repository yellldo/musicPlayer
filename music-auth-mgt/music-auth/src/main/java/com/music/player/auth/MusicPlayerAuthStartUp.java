package com.music.player.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ClassName : MusicPlayerAuthStartUp<br>
 * Description : MusicPlayerAuthStartUp<br>
 *
 * @author : sj
 * @date : 2024/3/18
 */
@EnableAspectJAutoProxy
//@EnableHystrix
@EnableCaching
@MapperScan(basePackages = "com.music.player.auth.mapper")
@EnableDiscoveryClient
@EnableFeignClients({"com.music.player.auth", "com.music.player"})
@SpringBootApplication(scanBasePackages = "com.music.player")
public class MusicPlayerAuthStartUp {

    public static void main(String[] args) {
        SpringApplication.run(MusicPlayerAuthStartUp.class, args);
    }
}
