package com.music.player.system.dto;

import com.music.player.framework.common.base.QueryRequestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysUserPageDto<br>
 * Description : SysUserPageDto<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString
public class SysUserPageDto extends QueryRequestParam {

    private String loginName;

    private String userStatus;

    private String isSuper;
}
