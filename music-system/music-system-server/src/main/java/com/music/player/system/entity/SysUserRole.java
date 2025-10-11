package com.music.player.system.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysUserRole<br>
 * Description : SysUserRole<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Setter
@Getter
@ToString
public class SysUserRole {

    @TableField("user_id")
    private Long userId;

    @TableField("role_id")
    private Long roleId;
}
