package com.music.player.infra.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * ClassName : DeleteSysRoleDto<br>
 * Description : DeleteSysRoleDto<br>
 *
 * @author : sj
 * @date : 2024/5/24
 */
@Setter
@Getter
@ToString
public class DeleteSysRoleDto implements Serializable {

    @NotNull(message = "参数异常")
    private Long roleId;

    private String delFlag;
}
