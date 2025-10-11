package com.music.player.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : DictInfo<br>
 * Description : DictInfo<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@Setter
@Getter
@ToString
@TableName("dict_info")
public class DictInfo extends BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父级id
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 字典类型
     */
    @TableField("dict_type")
    private String dictType;

    /**
     * 字典key
     */
    @TableField("dict_key")
    private String dictKey;

    /**
     * 字典value
     */
    @TableField("dict_value")
    private String dictValue;

    /**
     * 字典状态 0、正常 1、禁用
     */
    @TableField("dict_status")
    private String dictStatus;

    /**
     * 备注
     */
    @TableField("dict_remark")
    private String dictRemark;

    /**
     * 删除标志位 0、未删除 1、已删除
     */
    @TableField("is_delete")
    private String isDelete;
}
