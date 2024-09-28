package com.music.player.infra.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName : InfraFile<br>
 * Description : InfraFile<br>
 *
 * @author : sj
 * @date : 2024/9/22
 */
@Setter
@Getter
@ToString
@TableName("infra_file")
public class InfraFile implements Serializable {

    @TableId(value = "file_id", type = IdType.INPUT)
    private Long fileId;

    @TableField("file_name")
    private String fileName;

    @TableField("file_url")
    private String fileUrl;

    @TableField("file_size")
    private Integer fileSize;

    @TableField("file_channel")
    private String fileChannel;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
