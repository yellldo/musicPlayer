package com.music.player.framework.mybatis.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.music.player.framework.mybatis.constant.EntityConstant;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName : SuperEntity<br>
 * Description : SuperEntity<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class SuperEntity<T> implements Serializable {

    private static final long serialVersionUID = -4233577470258536688L;
    @TableId(value = EntityConstant.COLUMN_ID, type = IdType.INPUT)
    protected T id;

    @TableField(value = "created_by", fill = FieldFill.INSERT)
    private T createdBy;

    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

}
