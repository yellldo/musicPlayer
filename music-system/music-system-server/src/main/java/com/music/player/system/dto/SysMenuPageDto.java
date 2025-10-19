package com.music.player.system.dto;

import com.music.player.framework.common.base.QueryRequestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysMenuPageDto<br>
 * Description : SysMenuPageDto<br>
 *
 * @author : sj
 * @date : 10/16/25
 */
@Setter
@Getter
@ToString
public class SysMenuPageDto extends QueryRequestParam {

    private String menuName;
}
