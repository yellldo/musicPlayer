package com.music.player.framework.mybatis.core.enums;

import com.baomidou.mybatisplus.annotation.DbType;

/**
 * ClassName : SqlConstants<br>
 * Description : SQL相关常量类<br>
 *
 * @author : sj
 * @date : 2024/4/2
 */
public class SqlConstants {


    /**
     * 数据库的类型
     */
    public static DbType DB_TYPE;

    public static void init(DbType dbType) {
        DB_TYPE = dbType;
    }
}
