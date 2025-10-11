package com.music.player.framework.mybatis.config;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

/**
 * ClassName : P6spySqlFormatConfigure<br>
 * Description : P6spySqlFormatConfigure<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
public class P6spySqlFormatConfigure implements MessageFormattingStrategy {

    /**
     * 过滤掉定时任务的 SQL
     */
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return StringUtils.isNotBlank(sql) ? DateUtil.format(LocalDateTime.now(), DatePattern.NORM_DATETIME_PATTERN)
                + " | 耗时 " + elapsed + " ms | SQL 语句：" + StringUtils.LF + sql.replaceAll("[\\s]+", StringUtils.SPACE) + ";" : StringUtils.EMPTY;
    }
}
