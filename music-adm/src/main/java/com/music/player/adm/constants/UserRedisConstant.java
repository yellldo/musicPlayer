package com.music.player.adm.constants;

/**
 * ClassName : UserRedisConstant<br>
 * Description : redis 常量<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
public class UserRedisConstant {


    public static String SYS_USER_KEY = "sys:user:info:";

    /**
     * 后台用户登录过期时间
     */
    public static long SYS_USER_LOGIN_EXPIRE = 100;
    /**
     * 门户用户登录过期时间
     */
    public static long USER_LOGIN_EXPIRE = 100;
}
