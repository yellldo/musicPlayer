package com.music.player.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : DictDetail<br>
 * Description : DictDetail<br>
 *
 * @author : sj
 * @date : 10/19/25
 */
@Setter
@Getter
@ToString(callSuper = true)
public class DictDetail extends BaseEntity {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 父级id
     */
    @TableField("parent_id")
    private Long parentId;

    @TableField("dict_label")
    private String dictLabel;

    @TableField("dict_value")
    private String dictValue;

    @TableField("sort")
    private Integer sort;

    @TableField("dict_status")
    private String dictStatus;

    @TableField("dict_remark")
    private String dictRemark;
}
