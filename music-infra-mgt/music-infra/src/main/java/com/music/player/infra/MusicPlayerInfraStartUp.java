package com.music.player.infra;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName : MusicPlayerInfraStartUp<br>
 * Description : MusicPlayerInfraStartUp<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@MapperScan("com.music.player.infra.mapper")
@SpringBootApplication
public class MusicPlayerInfraStartUp {

    public static void main(String[] args) {
        SpringApplication.run(MusicPlayerInfraStartUp.class, args);
    }
}
