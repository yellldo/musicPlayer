package com.music.player.user.entity;

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
 * ClassName : UserInfo<br>
 * Description : UserInfo<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
@TableName("user_info")
@EqualsAndHashCode(callSuper = true)
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

    @TableField("grade")
    private Integer grade;

    @TableField("membership_level")
    private Integer membershipLevel;

    @TableField("follower_count")
    private Integer followerCount;

    @TableField("following_count")
    private Integer followingCount;

    @TableField("is_artist")
    private String isArtist;

    @TableField("is_authentication")
    private String isAuthentication;


}
