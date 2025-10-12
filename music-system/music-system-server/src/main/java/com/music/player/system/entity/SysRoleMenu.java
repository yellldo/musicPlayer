package com.music.player.system.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClassName : SysRoleMenu<br>
 * Description : SysRoleMenu<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class SysRoleMenu {

    @TableField("role_id")
    private Long roleId;

    @TableField("menu_id")
    private Long menuId;
}
