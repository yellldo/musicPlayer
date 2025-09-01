package com.music.player.framework.common.utils;

import cn.hutool.extra.spring.SpringUtil;

import java.util.Objects;

/**
 * ClassName : SpringUtils<br>
 * Description : Spring 工具类<br>
 *
 * @author : sj
 * @date : 9/1/25
 */
public class SpringUtils extends SpringUtil {

    /**
     * 是否为生产环境
     *
     * @return 是否生产环境
     */
    public static boolean isProd() {
        String activeProfile = getActiveProfile();
        return Objects.equals("prod", activeProfile);
    }

}
