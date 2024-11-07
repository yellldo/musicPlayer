package com.music.player.adm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : SysRoleMenu<br>
 * Description : SysRoleMenu<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Setter
@Getter
@ToString
@TableName("sys_role_menu")
public class SysRoleMenu implements Serializable {

    @TableField("role_id")
    private Long roleId;

    @TableField("menu_id")
    private Long menuId;
}
