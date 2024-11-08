package com.music.player.chief.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@TableName("author_apply_info")
public class AuthorApplyInfo {

    @TableId("author_apply_id")
    private Long authorApplyId;

    @TableField("user_id")
    private Long userId;

    @TableField("author_id")
    private Long authorId;

    @TableField("author_name")
    private String authorName;

    @TableField("gender")
    private String gender;

    @TableField("id_number")
    private String idNumber;

    @TableField("birthday")
    private String birthday;

    @TableField("school")
    private String school;

    @TableField("country")
    private String country;

    @TableField("city")
    private String city;

    @TableField("profile_photo")
    private String profilePhoto;

    @TableField("background_image")
    private String backgroundImage;

    @TableField("auditStatus")
    private String auditStatus;

    @TableField("audit_remark")
    private String auditRemark;

    @TableField("is_delete")
    private String isDelete;

    @TableField("create_time")
    private Date createTime;
}

