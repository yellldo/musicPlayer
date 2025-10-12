package com.music.player.system.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * ClassName : SysRoleAssignDto<br>
 * Description : SysRoleAssignDto<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString
public class SysRoleAssignDto extends SysRoleIdDto {

    private List<Long> menuIdList;

}
