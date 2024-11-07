package com.music.player.chief.api.service.author.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class AuthenticatedDto implements Serializable {

    @NotBlank(message = "请输入作者姓名")
    private String authorName;

    private Long userId;

    private String gender;

    private String country;

    private String city;

}
