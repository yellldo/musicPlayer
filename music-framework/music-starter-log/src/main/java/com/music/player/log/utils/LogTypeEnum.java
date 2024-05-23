package com.music.player.log.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * ClassName : LogTypeEnum<br>
 * Description : 日志类型<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
@Getter
@RequiredArgsConstructor
public enum LogTypeEnum {

    /**
     * 正常日志类型
     */
    NORMAL("0", "正常日志"),

    /**
     * 错误日志类型
     */
    ERROR("9", "错误日志");

    /**
     * 类型
     */
    private final String type;

    /**
     * 描述
     */
    private final String description;
}
