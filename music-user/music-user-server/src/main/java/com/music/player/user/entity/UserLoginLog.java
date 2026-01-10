package com.music.player.user.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * ClassName : UserLoginLog<br>
 * Description : UserLoginLog<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Setter
@Getter
@ToString(callSuper = true)
@TableName("user_login_log")
public class UserLoginLog {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("login_name")
    private String loginName;

    @TableField("ip")
    private String ip;

    @TableField("device")
    private String device;

    @TableField("is_success")
    private String isSuccess;

    @TableField("create_time")
    private LocalDateTime createTime;
}
