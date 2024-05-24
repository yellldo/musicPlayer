package com.music.player.infra.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ClassName : SysRole<br>
 * Description : SysRole<br>
 *
 * @author : sj
 * @date : 2024/5/24
 */
@Setter
@Getter
@ToString
@TableName("sys_role")
@EqualsAndHashCode(callSuper = true)
public class SysRole extends Model<SysRole> {


    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.ASSIGN_ID)
    private Long roleId;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 角色编码
     */
    @TableField("role_code")
    private String roleCode;

    /**
     * 角色描述
     */
    @TableField("role_desc")
    private String roleDesc;

    /**
     * 创建人
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 修改人
     */
    @TableField("update_by")
    public String updateBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 删除标记，0未删除，1已删除
     */
    @TableField(value = "del_flag", fill = FieldFill.INSERT)
    private String delFlag;
}
