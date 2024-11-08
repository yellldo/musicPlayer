package com.music.player.chief.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class QueryMusicApplyInfoVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long musicApplyId;

    private String authorName;
}
