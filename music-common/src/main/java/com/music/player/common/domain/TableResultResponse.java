package com.music.player.common.domain;

import java.util.List;

/**
 * ClassName : TableResultResponse<br>
 * Description : table请求返回格式<br>
 *
 * @author : sj
 * @date : 2024/3/18
 */
public class TableResultResponse<T> extends BaseResponse {

    TableData<T> data;

    public TableResultResponse() {
        this.data = new TableData<>();
    }

    public TableResultResponse(long total, List<T> rows) {
        this.data = new TableData<>(total, rows);
    }


    TableResultResponse<T> total(int total) {
        this.data.setTotal(total);
        return this;
    }

    TableResultResponse<T> total(List<T> rows) {
        this.data.setRows(rows);
        return this;
    }


    public TableData<T> getData() {
        return data;
    }

    public void setData(TableData<T> data) {
        this.data = data;
    }

    public class TableData<T> {
        long total;
        List<T> rows;

        public TableData(long total, List<T> rows) {
            this.total = total;
            this.rows = rows;
        }

        public TableData() {
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public List<T> getRows() {
            return rows;
        }

        public void setRows(List<T> rows) {
            this.rows = rows;
        }
    }
}
