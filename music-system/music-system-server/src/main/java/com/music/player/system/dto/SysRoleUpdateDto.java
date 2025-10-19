package com.music.player.system.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysRoleUpdateDto<br>
 * Description : SysRoleUpdateDto<br>
 *
 * @author : sj
 * @date : 10/18/25
 */
@Setter
@Getter
@ToString(callSuper = true)
public class SysRoleUpdateDto extends SysRoleIdDto {

    private String roleName;

    private String roleRemark;
}
