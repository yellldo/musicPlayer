package com.music.player.chief.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class ApprovalMusicDto implements Serializable {

    private Long musicApplyId;

    private String musicApplyStatus;

    private String musicApplyRemark;
}
