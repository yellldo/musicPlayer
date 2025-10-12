package com.music.player.system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysUserUpdateDto<br>
 * Description : SysUserUpdateDto<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString
public class SysUserUpdateDto {

    @NotNull(message = "参数异常")
    private Long userId;

    private String remark;

    private String nickName;

    private String userStatus;
}
