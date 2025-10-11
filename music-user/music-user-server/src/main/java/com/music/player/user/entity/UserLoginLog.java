package com.music.player.user.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@EqualsAndHashCode(callSuper = true)
public class UserLoginLog extends BaseEntity {

    @TableId
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("ip")
    private String ip;

    @TableField("device")
    private String device;
}
