package com.music.player.infra;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName : MusicPlayerInfraStartUp<br>
 * Description : MusicPlayerInfraStartUp<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@EnableDiscoveryClient
@MapperScan("com.music.player.infra.mapper")
@SpringBootApplication(scanBasePackages = "com.music.player")
public class MusicPlayerInfraStartUp {

    public static void main(String[] args) {
        SpringApplication.run(MusicPlayerInfraStartUp.class, args);
    }
}
