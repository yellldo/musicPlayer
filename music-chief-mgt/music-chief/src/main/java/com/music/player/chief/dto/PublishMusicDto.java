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
public class PublishMusicDto implements Serializable {

    private String musicName;

    private String musicCover;

    private Long authorId;

    private Integer collectCount;

    private String musicUrl;

    private Integer duration;

}
