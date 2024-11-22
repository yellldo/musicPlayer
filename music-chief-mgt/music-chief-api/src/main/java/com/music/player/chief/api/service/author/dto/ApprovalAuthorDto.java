package com.music.player.chief.api.service.author.dto;

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
public class ApprovalAuthorDto implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long authorApplyId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long authorId;

    private String auditStatus;

    private String auditRemark;

}
