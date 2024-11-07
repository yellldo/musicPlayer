package com.music.player.chief.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName : AuthorInfo<br>
 * Description : AuthorInfo<br>
 *
 * @author : sj
 * @date : 2024/10/15
 */
@TableName("author_info")
@Setter
@Getter
@ToString
public class AuthorInfo {

    @TableId("author_id")
    private Long authorId;

    @TableField("author_name")
    private String authorName;

    @TableField("gender")
    private String gender;

    @TableField("country")
    private String country;

    @TableField("city")
    private String city;

    @TableField("is_delete")
    private String isDelete;

    @TableField("create_time")
    private Date createTime;


}
