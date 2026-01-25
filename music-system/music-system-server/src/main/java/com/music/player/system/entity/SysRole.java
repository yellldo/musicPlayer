package com.music.player.system.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClassName : SysRole<br>
 * Description : SysRole<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Setter
@Getter
@Accessors(chain = true)
@TableName("sys_role")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long roleId;

    @TableField("role_name")
    private String roleName;

    @TableField("role_status")
    private String roleStatus;

    @TableField("role_remark")
    private String roleRemark;
}
