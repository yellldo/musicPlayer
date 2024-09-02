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
 * ClassName : SysMenu<br>
 * Description : SysMenu<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Setter
@Getter
@ToString
@TableName("sys_menu")
public class SysMenu implements Serializable {

    @TableId("menu_id")
    private Long menuId;

    @TableField("menu_name")
    private String menuName;

    @TableField("parent_id")
    private Long parentId;

    @TableField("priority")
    private Long priority;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}

