package com.music.player.adm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName : SysRole<br>
 * Description : SysRole<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Setter
@Getter
@ToString
@TableName("sys_role")
public class SysRole implements Serializable {

    @TableId("role_id")
    private Long roleId;

    @TableField("role_name")
    private String roleName;

    @TableField("role_desc")
    private String roleDesc;

    @TableField("enable")
    private String enable;

    @TableField("is_delete")
    private String isDelete;

    @TableField("create_time")
    private Date createTime;

    @TableField("create_by")
    private Long createBy;

    @TableField("update_by")
    private Date updateTime;

    @TableField("update_by")
    private Long updateBy;

}
