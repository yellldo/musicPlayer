package com.music.player.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * ClassName : UserServiceApplication<br>
 * Description : UserServiceApplication<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.music.player", "com.music.player.framework.web"})
@MapperScan("com.music.player.user.mapper")
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
