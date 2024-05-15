package com.music.player.framework.mybatis.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * ClassName : Entity<br>
 * Description : Entity<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Entity<T> extends SuperEntity<T> {

    @TableField(value = "updated_by", fill = FieldFill.INSERT_UPDATE)
    private T updatedBy;

    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    public Entity(T id, T createdBy, LocalDateTime createdAt,
                  T updatedBy, LocalDateTime updatedAt) {
        super(id, createdBy, createdAt);
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }
}
