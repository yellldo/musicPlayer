package com.music.player.system.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysMenuUpdateDto<br>
 * Description : SysMenuUpdateDto<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysMenuUpdateDto extends SysMenuIdDto {

    private String menuName;

    private String menuPath;

    private String icon;

    private String isShow;
}
