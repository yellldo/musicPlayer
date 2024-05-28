package com.music.player.infra.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * ClassName : SaveSysRoleDto<br>
 * Description : SaveSysRoleDto<br>
 *
 * @author : sj
 * @date : 2024/5/24
 */
@Setter
@Getter
@ToString
public class SaveSysRoleDto implements Serializable {

    @NotBlank(message = "请输入角色名称")
    @Schema(name = "角色名称")
    private String roleName;

    @NotBlank(message = "请输入角色编码")
    @Schema(name = "角色编码")
    private String roleCode;

    @Schema(name = "角色描述")
    private String roleDesc;
}
