package com.music.player.user.dto;

import jakarta.validation.constraints.NotBlank;
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
public class MemberLevelCreateDto implements Serializable {

    @NotBlank(message = "等级名称不能为空")
    private String name;

    @NotNull(message = "等级数值不能为空")
    private Integer level;

    private String icon;

    private Integer discount;

    private String description;

    private Integer sort;

    private String status;
}
