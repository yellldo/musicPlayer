package com.music.player.framework.mybatis.constant;

import com.baomidou.mybatisplus.core.conditions.ISqlSegment;
import lombok.AllArgsConstructor;

/**
 * ClassName : SqlConditions<br>
 * Description : SQL条件类型<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
@AllArgsConstructor
public enum SqlConditions implements ISqlSegment {

    EQ("="),
    IN("IN"),
    LIKE("LIKE"),
    LIST_IN("LIST_IN"),
    ;

    private final String keyword;

    @Override
    public String getSqlSegment() {
        return this.keyword;
    }
}
