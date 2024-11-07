package com.music.player.adm.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : SysRoleVo<br>
 * Description : SysRoleVo<br>
 *
 * @author : sj
 * @date : 2024/9/11
 */
@Setter
@Getter
@ToString
public class SysRoleVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

    private String roleName;

    private String roleDesc;

    private String enable;
}
