package com.music.player.user.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

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
public class CreateUserLoginLogDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -4434362953758054893L;

    private Long userId;

    private String loginName;

    private String isSuccess;

    private String ip;

    private String device;
}
