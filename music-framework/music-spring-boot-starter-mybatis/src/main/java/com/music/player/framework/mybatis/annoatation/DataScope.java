package com.music.player.framework.mybatis.annoatation;

/**
 * ClassName : DataScope<br>
 * Description : 多列数据权限注解<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
public @interface DataScope {

    /**
     * 数据权限id {@link com.music.player.framework.mybatis.properties.DataScopeConfig#getScopeId();}
     */
    String value() default "";
}
