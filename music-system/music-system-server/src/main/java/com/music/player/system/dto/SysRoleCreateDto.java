package com.music.player.system.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysRoleCreateDto<br>
 * Description : SysRoleCreateDto<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class SysRoleCreateDto {

    @NotBlank(message = "请输入角色名称")
    private String roleName;

    private String roleRemark;
}
