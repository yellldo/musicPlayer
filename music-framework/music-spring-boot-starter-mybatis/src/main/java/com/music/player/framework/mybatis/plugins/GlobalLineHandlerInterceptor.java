package com.music.player.framework.mybatis.plugins;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.music.player.framework.common.context.RequestLocalContextHolder;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;

import java.util.List;

/**
 * ClassName : GlobalLineHandlerInterceptor<br>
 * Description : 全局行级处理器<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
public class GlobalLineHandlerInterceptor implements TenantLineHandler {

    private final String tenantIdColumn;
    private final List<String> ignoreTableList;
    private final String loadKey;

    public GlobalLineHandlerInterceptor(String tenantIdColumn, String loadKey, List<String> ignoreTableList) {
        this.tenantIdColumn = tenantIdColumn;
        this.loadKey = loadKey;
        this.ignoreTableList = ignoreTableList;
    }

    @Override
    public Expression getTenantId() {
        return new StringValue(RequestLocalContextHolder.get(loadKey));
    }

    @Override
    public String getTenantIdColumn() {
        return tenantIdColumn;
    }

    @Override
    public boolean ignoreTable(String tableName) {
        return ignoreTableList.contains(tableName);
    }
}
