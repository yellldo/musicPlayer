package com.music.player.system.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * ClassName : SysRoleVo<br>
 * Description : SysRoleVo<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class SysRoleVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

    private String roleName;

    private String roleRemark;

    private String roleStatus;

    private LocalDateTime createTime;
}
