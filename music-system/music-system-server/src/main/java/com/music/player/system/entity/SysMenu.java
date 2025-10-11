package com.music.player.system.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysMenu<br>
 * Description : SysMenu<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Setter
@Getter
@TableName("sys_menu")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysMenu extends BaseEntity {

    @TableId
    private Long menuId;

    @TableField("parent_id")
    private Long parentId;

    @TableField("menu_name")
    private String menuName;

    @TableField("icon")
    private String icon;

    @TableField("level")
    private int level;

    @TableField("menu_type")
    private String menuType;

    @TableField("is_show")
    private String isShow;

    @TableField("is_delete")
    private String isDelete;
}
