package com.music.player.chief.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.music.player.chief.api.service.author.vo.AuthorInfoVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class QueryAuthorListVo extends AuthorInfoVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long authorId;
}
