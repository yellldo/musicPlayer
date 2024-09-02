package com.music.player.auth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : SysUserRole<br>
 * Description : SysUserRole<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Setter
@Getter
@ToString
@TableName("sys_user_role")
public class SysUserRole implements Serializable {

    @TableField("user_id")
    private Long userId;

    @TableField("role_id")
    private Long roleId;
}
