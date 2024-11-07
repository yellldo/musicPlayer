package com.music.player.auth.api.service.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class RelevanceAuthorDto implements Serializable {

    private Long userId;

    private Long authorId;

}
