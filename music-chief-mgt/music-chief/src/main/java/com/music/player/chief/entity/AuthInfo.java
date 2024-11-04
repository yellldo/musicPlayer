package com.music.player.chief.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName : AuthInfo<br>
 * Description : AuthInfo<br>
 *
 * @author : sj
 * @date : 2024/10/15
 */
@TableName("auth_info")
@Setter
@Getter
@ToString
public class AuthInfo {

    @TableId("auth_id")
    private Long authId;

    @TableField("auth_name")
    private String authName;

    @TableField("is_delete")
    private String isDelete;

    @TableField("auth_status")
    private String authStatus;

    @TableField("create_time")
    private Date createTime;


}
