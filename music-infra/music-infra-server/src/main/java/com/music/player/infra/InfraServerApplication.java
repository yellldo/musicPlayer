package com.music.player.infra;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName : InfraServerApplication<br>
 * Description : InfraServerApplication<br>
 *
 * @author : sj
 * @date : 9/1/25
 */
@MapperScan("com.music.player.infra.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class InfraServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfraServerApplication.class, args);
    }
}
