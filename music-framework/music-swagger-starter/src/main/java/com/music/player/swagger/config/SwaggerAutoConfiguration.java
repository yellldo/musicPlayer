package com.music.player.swagger.config;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.music.player.swagger.properties.SwaggerProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;
import java.util.function.Function;

/**
 * ClassName : SwaggerAutoConfiguration<br>
 * Description :  swagger 包扫描配置<br>
 *
 * @author : sj
 * @date : 2024/9/3
 */
@Import({
        SwaggerConfiguration.class
})
@ConditionalOnProperty(prefix = "knife4j", name = "enable", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerAutoConfiguration implements BeanFactoryAware {

    private static final String SEMICOLON = ";";
    private final SwaggerProperties swaggerProperties;
    private BeanFactory beanFactory;

    public SwaggerAutoConfiguration(SwaggerProperties swaggerProperties) {
        this.swaggerProperties = swaggerProperties;
    }

    private static Predicate<String> ant(final String antPattern) {
        return input -> new AntPathMatcher().match(antPattern, input);
    }

    private static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).map(handlerPackage(basePackage)).orElse(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return input -> StrUtil.split(basePackage, SEMICOLON).stream().anyMatch(ClassUtils.getPackageName(input)::startsWith);
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.ofNullable(input.declaringClass());
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Bean
    @ConditionalOnMissingBean
    public List<Docket> createRestApi() {
        ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) beanFactory;
        List<Docket> docketList = new LinkedList<>();

        // 没有分组
        if (swaggerProperties.getDocket().isEmpty()) {
            Docket docket = createDocket(swaggerProperties);
            configurableBeanFactory.registerSingleton(swaggerProperties.getTitle(), docket);
            docketList.add(docket);
            return docketList;
        }

        // 分组创建
        for (String groupName : swaggerProperties.getDocket().keySet()) {
            SwaggerProperties.DocketInfo docketInfo = swaggerProperties.getDocket().get(groupName);

            ApiInfo apiInfo = new ApiInfoBuilder()
                    .title(docketInfo.getTitle().isEmpty() ? swaggerProperties.getTitle() : docketInfo.getTitle())
                    .description(docketInfo.getDescription().isEmpty() ? swaggerProperties.getDescription() : docketInfo.getDescription())
                    .version(docketInfo.getVersion().isEmpty() ? swaggerProperties.getVersion() : docketInfo.getVersion())
                    .license(docketInfo.getLicense().isEmpty() ? swaggerProperties.getLicense() : docketInfo.getLicense())
                    .licenseUrl(docketInfo.getLicenseUrl().isEmpty() ? swaggerProperties.getLicenseUrl() : docketInfo.getLicenseUrl())
                    .contact(
                            new Contact(
                                    docketInfo.getContact().getName().isEmpty() ? swaggerProperties.getContact().getName()
                                            : docketInfo.getContact().getName(),
                                    docketInfo.getContact().getUrl().isEmpty() ? swaggerProperties.getContact().getUrl()
                                            : docketInfo.getContact().getUrl(),
                                    docketInfo.getContact().getEmail().isEmpty() ?
                                            swaggerProperties.getContact().getEmail() :
                                            docketInfo.getContact().getEmail()
                            )
                    )
                    .termsOfServiceUrl(
                            docketInfo.getTermsOfServiceUrl().isEmpty() ? swaggerProperties.getTermsOfServiceUrl()
                                    : docketInfo.getTermsOfServiceUrl())
                    .build();


            Docket docket = new Docket(DocumentationType.SWAGGER_2)
                    .host(swaggerProperties.getHost())
                    .apiInfo(apiInfo)
                    .groupName(docketInfo.getGroup())
                    .select()
                    .apis(basePackage(docketInfo.getBasePackage()))
                    .build()
                    .globalResponseMessage(RequestMethod.GET, getResponseMessages())
                    .globalResponseMessage(RequestMethod.POST, getResponseMessages())
                    .globalResponseMessage(RequestMethod.PUT, getResponseMessages())
                    .globalResponseMessage(RequestMethod.DELETE, getResponseMessages());
            if (ArrayUtil.isNotEmpty(swaggerProperties.getIgnoredClasses())) {
                docket.ignoredParameterTypes(swaggerProperties.getIgnoredClasses());
            }
            configurableBeanFactory.registerSingleton(groupName, docket);
            docketList.add(docket);
        }
        return docketList;
    }

    /**
     * 创建 Docket对象
     *
     * @param swaggerProperties swagger配置
     * @return Docket
     */
    private Docket createDocket(SwaggerProperties swaggerProperties) {
        //API 基础信息
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion())
                .license(swaggerProperties.getLicense())
                .licenseUrl(swaggerProperties.getLicenseUrl())
                .contact(new Contact(swaggerProperties.getContact().getName(),
                        swaggerProperties.getContact().getUrl(),
                        swaggerProperties.getContact().getEmail()))
                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                .build();

        // base-path处理
        // 当没有配置任何path的时候，解析/**
        if (swaggerProperties.getIncludePath().isEmpty()) {
            swaggerProperties.getIncludePath().add("/**");
        }
        List<Predicate<String>> basePath = new ArrayList<>();
        for (String path : swaggerProperties.getIncludePath()) {
            basePath.add(ant(path));
        }

        // exclude-path处理
        List<Predicate<String>> excludePath = new ArrayList<>();
        for (String path : swaggerProperties.getExcludePath()) {
            excludePath.add(ant(path));
        }

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerProperties.getHost())
                .apiInfo(apiInfo)
                .groupName(swaggerProperties.getGroup())
                .select()
                .apis(basePackage(swaggerProperties.getBasePackage()))
                .paths(Predicates.and(Predicates.not(Predicates.or(excludePath)), Predicates.or(basePath)))
                .build()
                .globalResponseMessage(RequestMethod.GET, getResponseMessages())
                .globalResponseMessage(RequestMethod.POST, getResponseMessages())
                .globalResponseMessage(RequestMethod.PUT, getResponseMessages())
                .globalResponseMessage(RequestMethod.DELETE, getResponseMessages());
        if (ArrayUtil.isNotEmpty(swaggerProperties.getIgnoredClasses())) {
            docket.ignoredParameterTypes(swaggerProperties.getIgnoredClasses());
        }
        return docket;
    }


    private List<ResponseMessage> getResponseMessages() {
        return Arrays.asList(
                new ResponseMessageBuilder().code(200).message("成功").build(),
                new ResponseMessageBuilder().code(500).message("哎呀，开了个小差，请稍后再试").build(),
                new ResponseMessageBuilder().code(401).message("暂未登录或者token失效").build(),
                new ResponseMessageBuilder().code(403).message("无权限访问").build(),
                new ResponseMessageBuilder().code(230).message("Token过期").build()
        );
    }


}
