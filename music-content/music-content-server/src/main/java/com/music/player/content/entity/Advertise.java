package com.music.player.content.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName : Advertise<br>
 * Description : 广告投放<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Setter
@Getter
@ToString
@TableName("advertise")
public class Advertise extends BaseEntity implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("title")
    private String title;

    @TableField("type")
    private String type;

    @TableField("image_url")
    private String imageUrl;

    @TableField("link_url")
    private String linkUrl;

    @TableField("position")
    private String position;

    @TableField("sort_order")
    private Integer sortOrder;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("start_time")
    private LocalDateTime startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("end_time")
    private LocalDateTime endTime;

    @TableField("status")
    private String status;

    @TableField("remark")
    private String remark;
}
