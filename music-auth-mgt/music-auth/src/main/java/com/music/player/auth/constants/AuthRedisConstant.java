package com.music.player.auth.constants;

/**
 * ClassName : AuthRedisConstant<br>
 * Description : redis 常量<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
public class AuthRedisConstant {


    public static String USER_KEY = "user:info:";

    /**
     * 门户用户登录过期时间
     */
    public static long USER_LOGIN_EXPIRE = 100;
}
