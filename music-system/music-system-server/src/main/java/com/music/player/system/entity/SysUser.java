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

    @TableField("user_status")
    private String userStatus;

    @TableField("error_count")
    private int errorCount;


}
