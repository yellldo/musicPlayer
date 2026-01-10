package com.music.player.content.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName : ArtistsAudit<br>
 * Description : ArtistsAudit<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@Setter
@Getter
@ToString
@TableName("artists_audit")
public class ArtistsAudit extends BaseEntity implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("audit_status")
    private String auditStatus;

    @TableField("audit_type")
    private String auditType;

    @TableField("reject_reason")
    private String rejectReason;

    @TableField("submitted_data")
    private String submittedData;

    @TableField("auditor_id")
    private Long auditorId;

    @TableField("audit_notes")
    private String auditNotes;

    @TableField("audited_time")
    private LocalDateTime auditedTime;

    @TableField("withdrawn_time")
    private LocalDateTime withdrawnTime;
}
