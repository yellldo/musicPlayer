package com.music.player.swagger.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName : SwaggerWebMvcConfigurer<br>
 * Description : Swagger 配置<br>
 *
 * @author : sj
 * @date : 2024/9/3
 */
public class SwaggerWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars" +
                        "*")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
