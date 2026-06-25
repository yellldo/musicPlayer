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
public class MemberGroupUpdateDto implements Serializable {

    @NotNull(message = "分组ID不能为空")
    private Long id;

    private String name;

    private Integer sort;

    private String status;
}
