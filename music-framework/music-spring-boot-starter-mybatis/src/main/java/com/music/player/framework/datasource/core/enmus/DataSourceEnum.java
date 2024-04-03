package com.music.player.framework.datasource.core.enmus;

/**
 * ClassName : DataSourceEnum<br>
 * Description : 通过在方法上，使用 {@link com.baomidou.dynamic.datasource.annotation.DS} 注解，设置使用的数据源。
 * <p>
 * 注意，默认是 {@link #MASTER} 数据源
 * 对应官方文档为 http://dynamic-datasource.com/guide/customize/Annotation.html<br>
 *
 * @author : sj
 * @date : 2024/4/3
 */
public interface DataSourceEnum {

    /**
     * 主库，推荐使用 {@link com.baomidou.dynamic.datasource.annotation.Master} 注解
     */
    String MASTER = "master";
    /**
     * 从库，推荐使用 {@link com.baomidou.dynamic.datasource.annotation.Slave} 注解
     */
    String SLAVE = "slave";
}
