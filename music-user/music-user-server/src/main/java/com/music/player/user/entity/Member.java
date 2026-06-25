package com.music.player.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * ClassName : Member<br>
 * Description : 会员<br>
 *
 * @author : sj
 * @date : 6/24/26
 */
@Setter
@Getter
@ToString
@TableName("member")
public class Member extends BaseEntity implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("username")
    private String username;

    @TableField("nickname")
    private String nickname;

    @TableField("avatar")
    private String avatar;

    @TableField("phone")
    private String phone;

    @TableField("gender")
    private String gender;

    @TableField("birthday")
    private LocalDate birthday;

    @TableField("level_id")
    private Long levelId;

    @TableField("group_id")
    private Long groupId;

    @TableField("tag_ids")
    private String tagIds;

    @TableField("points")
    private Integer points;

    @TableField("status")
    private String status;
}
