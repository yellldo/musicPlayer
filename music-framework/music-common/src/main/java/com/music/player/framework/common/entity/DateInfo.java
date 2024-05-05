package com.music.player.framework.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * ClassName : DateInfo<br>
 * Description : 开始结束时间通用实体类<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Data
public class DateInfo {

    private Date startDate;

    private String startTime;

    private Date endDate;

    private String endTime;
}
