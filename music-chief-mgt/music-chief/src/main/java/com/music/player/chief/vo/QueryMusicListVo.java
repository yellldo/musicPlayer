package com.music.player.chief.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.music.player.chief.api.service.music.vo.MusicInfoVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class QueryMusicListVo extends MusicInfoVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long musicId;

    private String musicName;

    private String authorName;

}
