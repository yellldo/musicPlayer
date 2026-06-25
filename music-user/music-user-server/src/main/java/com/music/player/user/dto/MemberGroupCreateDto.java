package com.music.player.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class MemberGroupCreateDto implements Serializable {

    @NotBlank(message = "分组名称不能为空")
    private String name;

    private Integer sort;

    private String status;
}
