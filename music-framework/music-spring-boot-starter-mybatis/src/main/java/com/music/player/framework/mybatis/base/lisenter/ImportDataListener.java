package com.music.player.framework.mybatis.base.lisenter;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName : ImportDataListener<br>
 * Description : excel监听处理类<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public class ImportDataListener<ExcelEntity> extends AnalysisEventListener<ExcelEntity> {

    public List<ExcelEntity> list;
    protected AtomicInteger count;

    public Integer getCount() {
        return count.get();
    }

    public void setCount(int value) {
        this.count = new AtomicInteger(value);
    }

    @Override
    public void invoke(ExcelEntity excelEntity, AnalysisContext analysisContext) {
        list.add(excelEntity);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public List<ExcelEntity> getList() {
        return list;
    }

    public void setList(List<ExcelEntity> list) {
        this.list = list;
    }
}
