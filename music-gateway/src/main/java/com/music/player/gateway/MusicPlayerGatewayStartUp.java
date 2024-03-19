package com.music.player.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName : MusicPlayerGatewayStartUp<br>
 * Description : MusicPlayerGatewayStartUp<br>
 *
 * @author : sj
 * @date : 2024/3/18
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MusicPlayerGatewayStartUp {

    public static void main(String[] args) {
        SpringApplication.run(MusicPlayerGatewayStartUp.class, args);
    }
}
