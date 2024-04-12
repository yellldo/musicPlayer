package com.music.player.infra.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName : ApiErrorLogProcessStatusEnum<br>
 * Description : ApiErrorLogProcessStatusEnum<br>
 *
 * @author : sj
 * @date : 2024/4/6
 */
@Getter
@AllArgsConstructor
public enum ApiErrorLogProcessStatusEnum {

    INIT(0, "未处理"),
    DONE(1, "已处理"),
    IGNORE(2, "已忽略");

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 资源类型名
     */
    private final String name;
}
