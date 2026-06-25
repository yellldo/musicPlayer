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
public class MemberLevelUpdateDto implements Serializable {

    @NotNull(message = "等级ID不能为空")
    private Long id;

    private String name;

    private Integer level;

    private String icon;

    private Integer discount;

    private String description;

    private Integer sort;

    private String status;
}
