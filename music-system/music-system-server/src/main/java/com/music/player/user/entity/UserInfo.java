package com.music.player.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClassName : UserInfo<br>
 * Description : UserInfo<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserInfo extends BaseEntity {

    @TableId(type = IdType.INPUT)
    private Long userId;

    @TableField("user_status")
    private String userStatus;

    @TableField("user_type")
    private String userType;

    @TableField("profile")
    private String profile;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;

    @TableField("nick_name")
    private String nickName;

    @TableField("avatar")
    private String avatar;

    @TableField("gender")
    private String gender;

    @TableField("birthday")
    private String birthday;

    @TableField("province")
    private String province;

    @TableField("city")
    private String city;
}
