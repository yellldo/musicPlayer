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

/**
 * ClassName : MemberLevel<br>
 * Description : 会员等级<br>
 *
 * @author : sj
 * @date : 6/24/26
 */
@Setter
@Getter
@ToString
@TableName("member_level")
public class MemberLevel extends BaseEntity implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("level")
    private Integer level;

    @TableField("icon")
    private String icon;

    @TableField("discount")
    private Integer discount;

    @TableField("description")
    private String description;

    @TableField("sort")
    private Integer sort;

    @TableField("status")
    private String status;
}
