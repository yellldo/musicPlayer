package com.music.player.chief.api.service.author.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class FetchAuthorInfoVo extends AuthorInfoVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long authorId;

}
