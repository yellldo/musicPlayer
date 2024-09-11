package com.music.player.infra;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName : MusicPlayerInfraStartUp<br>
 * Description : MusicPlayerInfraStartUp<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@EnableFeignClients(basePackages = {"com.music.player.auth", "com.music.player.infra"})
@EnableDiscoveryClient
@MapperScan("com.music.player.infra.mapper")
@SpringBootApplication(scanBasePackages = {"com.music.player.auth", "com.music.player.infra", "com.music.player.framework"})
public class MusicPlayerInfraStartUp {

    public static void main(String[] args) {
        SpringApplication.run(MusicPlayerInfraStartUp.class, args);
    }
}
