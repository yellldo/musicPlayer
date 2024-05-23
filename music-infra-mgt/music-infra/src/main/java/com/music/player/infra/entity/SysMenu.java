package com.music.player.infra.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName : SysMenu<br>
 * Description : SysMenu<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
@Setter
@Getter
@ToString
@TableName("sys_menu")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId(value = "menu_id", type = IdType.ASSIGN_ID)
    private Long menuId;

    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 菜单名称
     */
    @TableField("en_name")
    private String enName;

    /**
     * 菜单权限标识
     */
    @TableField("permission")
    private String permission;

    /**
     * 父菜单ID
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 前端路由标识路径，默认和 comment 保持一致 过期
     */
    @TableField("path")
    private String path;

    /**
     * 菜单显示隐藏控制
     */
    @TableField("visible")
    private String visible;

    /**
     * 排序值
     */
    @TableField("sort_order")
    private Integer sortOrder;

    /**
     * 菜单类型 （0菜单 1按钮）
     */
    @TableField("menu_type")
    private String menuType;

    /**
     * 路由缓冲
     */
    @TableField("keep_alive")
    private String keepAlive;

    @TableField("embedded")
    private String embedded;

    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 修改人
     */
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 0--正常 1--删除
     */
    @TableLogic
    @TableField(value = "del_flag", fill = FieldFill.INSERT)
    private String delFlag;
}
