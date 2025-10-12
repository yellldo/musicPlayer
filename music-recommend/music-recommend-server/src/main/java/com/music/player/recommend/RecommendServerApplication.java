package com.music.player.recommend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName : RecommendServerApplication<br>
 * Description : RecommendServerApplication<br>
 *
 * @author : sj
 * @date : 10/11/25
 */
@EnableDiscoveryClient
@MapperScan("com.music.player.recommend.mapper")
@SpringBootApplication
public class RecommendServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecommendServerApplication.class, args);
    }
}
