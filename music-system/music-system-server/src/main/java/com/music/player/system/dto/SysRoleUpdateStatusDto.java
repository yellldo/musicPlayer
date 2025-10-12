package com.music.player.system.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysRoleUpdateStatusDto<br>
 * Description : SysRoleUpdateStatusDto<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysRoleUpdateStatusDto extends SysRoleIdDto {

    private String roleStatus;
}
