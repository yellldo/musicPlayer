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
 * ClassName : SysUser<br>
 * Description : SysUser<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {

    @TableId(type = IdType.INPUT)
    private Long userId;

    @TableField("login_name")
    private String loginName;

    @TableField("nick_name")
    private String nickName;

    @TableField("password")
    private String password;

    @TableField("email")
    private String email;

    @TableField("phone")
    private String phone;

    @TableField("remark")
    private String remark;

    @TableField("is_super")
    private String isSuper;

    @TableField("is_reset")
    private String isReset;

    @TableField("user_status")
    private String userStatus;

    @TableField("error_count")
    private int errorCount;


}
