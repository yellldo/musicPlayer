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
 * ClassName : SysUser<br>
 * Description : SysUser<br>
 *
 * @author : sj
 * @date : 2024/3/20
 */
@Setter
@Getter
@ToString
@TableName("sys_user")
public class SysUser implements Serializable {

    @TableId("user_id")
    private Long userId;

    @TableField("login_name")
    private String loginName;

    @TableField("nick_name")
    public String nickName;

    @TableField("password")
    private String password;

    @TableField("user_status")
    private String userStatus;

    @TableField("is_delete")
    private String isDelete;

    @TableField("create_time")
    private Date createTime;

}
