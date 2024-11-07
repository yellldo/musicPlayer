package com.music.player.adm.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * ClassName : ModifyRoleDto<br>
 * Description : ModifyRoleDto<br>
 *
 * @author : sj
 * @date : 2024/9/11
 */
@Setter
@Getter
@ToString
public class ModifyRoleDto implements Serializable {

    @NotNull(message = "参数异常")
    private Long roleId;

    private String roleName;

    private String roleDesc;

    private String enable;

    private String isDelete;
}
