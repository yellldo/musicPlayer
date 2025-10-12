package com.music.player.system.dto;

import com.music.player.framework.common.base.QueryRequestParam;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysRolePageDto<br>
 * Description : SysRolePageDto<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysRolePageDto extends QueryRequestParam {

    private String roleName;

    private String roleStatus;
}
