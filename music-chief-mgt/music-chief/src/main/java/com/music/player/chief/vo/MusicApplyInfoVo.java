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
public class MusicApplyInfoVo implements Serializable {

    private String musicName;

    private String musicCover;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long authorId;

    private String musicUrl;

    private Integer duration;

    private String musicStatus;

    private String isDelete;

    private Date createTime;
}
