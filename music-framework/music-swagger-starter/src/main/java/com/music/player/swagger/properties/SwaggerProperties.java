package com.music.player.swagger.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName : SwaggerProperties<br>
 * Description : swagger2 属性配置<br>
 *
 * @author : sj
 * @date : 2024/9/3
 */
@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "knife4j")
public class SwaggerProperties {

    /*
     * 标题
     */
    private String title = "在线文档";

    private String group = "";
    /*
     * 描述
     */
    private String description = "磊哥的音乐播放器 在线文档";
    /*
     * 版本
     */
    private String version = "1.0";

    /*
     * 解析的包路径
     **/
    private String basePackage = "com.music.player";
    /*
     * 基础路径
     */
    private String basePath = "/";

    private Contact contact;
    /*
     * 许可证
     */
    private String license;
    /*
     * 许可证url
     */
    private String licenseUrl;
    /*
     * 服务条款URL
     */
    private String termsOfServiceUrl;

    private Class[] ignoredClasses;

    /*
     * swagger会解析的url规则
     */
    private List<String> includePath = new ArrayList<>();
    /*
     * 在includePath基础上需要排除的url规则
     */
    private List<String> excludePath = new ArrayList<>();

    /**
     * 分组文档
     **/
    private Map<String, DocketInfo> docket = new LinkedHashMap<>();

    /**
     * host信息
     **/
    private String host = "";

    /**
     * 排序
     */
    private Integer order = 1;


    @Data
    public static class DocketInfo {

        /**
         * 标题
         **/
        private String title = "在线文档";
        /**
         * 自定义组名
         */
        private String group = "";
        /**
         * 描述
         **/
        private String description = "磊哥音乐播放器 在线文档";
        /**
         * 版本
         **/
        private String version = "";
        /**
         * 许可证
         **/
        private String license = "";
        /**
         * 许可证URL
         **/
        private String licenseUrl = "";
        /**
         * 服务条款URL
         **/
        private String termsOfServiceUrl = "";

        private Contact contact = new Contact();

        /**
         * swagger会解析的包路径
         **/
        private String basePackage = "";

        private String basePath = "/";


        /**
         *
         */
        private List<ApiKey> apiKeys = new ArrayList<>();
        /**
         * 排序
         */
        private Integer order = 1;

        public String getGroup() {
            if (group == null || "".equals(group)) {
                return title;
            }
            return group;
        }
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Contact {

        /**
         * 联系人
         **/
        private String name = "";
        /**
         * 联系人url
         **/
        private String url = "";
        /**
         * 联系人email
         **/
        private String email = "";
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ApiKey {

        private String name;
        private String keyName;
        private String passAs = "header";
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AllowableValues {

        private List<String> values;
        private String valueType;
    }

}
