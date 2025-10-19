package com.music.player.framework.mybatis.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName : MybatisPlusConfig<br>
 * Description : MybatisPlusConfig<br>
 *
 * @author : sj
 * @date : 10/18/25
 */
@Configuration
public class MybatisPlusConfig {


    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        return new PaginationInnerInterceptor(DbType.MYSQL);
    }
}
