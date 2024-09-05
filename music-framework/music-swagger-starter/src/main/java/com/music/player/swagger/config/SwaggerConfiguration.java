package com.music.player.swagger.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


import static com.music.player.swagger.config.SwaggerConfiguration.TRUE;

/**
 * ClassName : SwaggerConfiguration<br>
 * Description :
 * 1，配置文件中： ${SwaggerProperties.PREFIX}.enable=true
 * 2，配置文件中不存在： ${SwaggerProperties.PREFIX}.enable 值<br>
 *
 * @author : sj
 * @date : 2024/9/3
 */
@EnableSwagger2WebMvc
@Import(BeanValidatorPluginsConfiguration.class)
@ConditionalOnProperty(prefix = "knife4j", name = "enable", havingValue = TRUE, matchIfMissing = true)
public class SwaggerConfiguration {

    public static final String TRUE = "true";

    @Bean
    @ConditionalOnClass(SwaggerWebMvcConfigurer.class)
    public SwaggerWebMvcConfigurer getSwaggerWebMvcConfigurer() {
        return new SwaggerWebMvcConfigurer();
    }
}
