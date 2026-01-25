package com.music.player.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
public class DictInfo extends BaseEntity {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;


    /**
     * 字典类型
     */
    @TableField("dict_type")
    private String dictType;

    @TableField("dict_code")
    private String dictCode;

    @TableField("dict_name")
    private String dictName;

    @TableField("sort")
    private Integer sort;

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


}
