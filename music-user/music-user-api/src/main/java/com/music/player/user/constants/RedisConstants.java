package com.music.player.user.constants;

/**
 * ClassName : RedisConstants<br>
 * Description : redis key 常量<br>
 *
 * @author : sj
 * @date : 10/9/25
 */
public class RedisConstants {

    public static final String USER_PREFIX = "user:";

    public static final String LOGIN_PHONE_CODE = USER_PREFIX + "login:code:";
    public static final String REGISTER_PHONE_CODE = USER_PREFIX + "register:code:";

}
