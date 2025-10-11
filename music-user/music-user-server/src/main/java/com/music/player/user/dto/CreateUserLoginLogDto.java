package com.music.player.user.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClassName : CreateUserLoginLogDto<br>
 * Description : CreateUserLoginLogDto<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class CreateUserLoginLogDto {

    private Long userId;

    private String ip;

    private String device;
}
