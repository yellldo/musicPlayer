package com.music.player.adm.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class AdmApprovalAuthorDto implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long authorApplyId;

    private String auditStatus;

    private String auditRemark;
}
