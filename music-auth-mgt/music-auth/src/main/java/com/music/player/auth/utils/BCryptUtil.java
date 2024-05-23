package com.music.player.auth.utils;


import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * ClassName: BCryptUtil
 * Description:
 * Date:  2024/5/20 16:53
 *
 * @author zhaot
 */
@Service
public class BCryptUtil {

    /**
     * 密码加密
     * @param password 密码
     * @return 加密密码
     */
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * 验证密码
     * @param password 密码
     * @param hashedPassword 密码验证
     * @return -
     */
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

}
