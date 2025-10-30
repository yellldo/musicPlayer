package com.music.player.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ClassName : SystemServerApplication<br>
 * Description : SystemServerApplication<br>
 *
 * @author : sj
 * @date : 9/1/25
 */
@EnableDiscoveryClient
@EnableAspectJAutoProxy
@MapperScan(value = {"com.music.player.system.mapper"})
@SpringBootApplication
public class SystemServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemServerApplication.class, args);
    }
}
