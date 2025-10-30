package com.music.player.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName : AdmGatewayApplication<br>
 * Description : AdmGatewayApplication<br>
 *
 * @author : sj
 * @date : 10/26/25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AdmGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdmGatewayApplication.class, args);
    }
}
