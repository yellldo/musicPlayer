package com.music.player.framework.mybatis;

import com.music.player.framework.mybatis.handler.MetaDataHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * ClassName : MusicMybatisAutoConfiguration<br>
 * Description : MusicMybatisAutoConfiguration<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@AutoConfiguration
public class MusicMybatisAutoConfiguration {


    @Bean
    public MetaDataHandler metaDataHandler() {
        return new MetaDataHandler();
    }
}
