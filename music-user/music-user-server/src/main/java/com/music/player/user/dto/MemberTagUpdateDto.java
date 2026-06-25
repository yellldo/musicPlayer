package com.music.player.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class MemberTagUpdateDto implements Serializable {

    @NotNull(message = "标签ID不能为空")
    private Long id;

    private String name;

    private String color;

    private Integer sort;

    private String status;
}
