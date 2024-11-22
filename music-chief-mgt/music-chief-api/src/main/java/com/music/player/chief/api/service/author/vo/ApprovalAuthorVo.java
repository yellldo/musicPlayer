package com.music.player.chief.api.service.author.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class ApprovalAuthorVo implements Serializable {

    private Long userId;

    private Long authorId;
}
