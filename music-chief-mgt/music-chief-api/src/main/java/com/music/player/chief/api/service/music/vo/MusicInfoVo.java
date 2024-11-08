package com.music.player.chief.api.service.music.vo;

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
public class MusicInfoVo implements Serializable {

    private String musicName;

    private String musicStatus;

    private String musicUrl;

    private String musicCover;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long authorId;

}
