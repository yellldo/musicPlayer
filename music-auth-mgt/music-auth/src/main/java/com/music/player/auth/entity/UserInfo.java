package com.music.player.auth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName : UserInfo<br>
 * Description : UserInfo<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@Setter
@Getter
@ToString
@TableName("user_info")
public class UserInfo implements Serializable {


    @TableId("user_id")
    private Long userId;

    @TableField("user_name")
    private String userName;

    @TableField("login_type")
    private String loginType;

    @TableField("password")
    private String password;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;

    @TableField("user_status")
    private String userStatus;

    @TableField("is_delete")
    private String isDelete;

    @TableField("is_vip")
    private String isVip;

    @TableField("create_time")
    private Date createTime;
}
