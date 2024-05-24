package com.music.player.infra.api.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : QuerySysRoleVo<br>
 * Description : QuerySysRoleVo<br>
 *
 * @author : sj
 * @date : 2024/5/24
 */
@Setter
@Getter
@ToString
public class QuerySysRoleVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

    private String roleName;

    private String roleCode;

    private String roleDesc;

}
