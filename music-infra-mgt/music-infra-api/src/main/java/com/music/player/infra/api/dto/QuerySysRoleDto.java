package com.music.player.infra.api.dto;

import com.music.player.framework.common.base.QueryRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : QuerySysRoleDto<br>
 * Description : QuerySysRoleDto<br>
 *
 * @author : sj
 * @date : 2024/5/24
 */
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class QuerySysRoleDto extends QueryRequest {

    @Schema(name = "角色名称")
    private String roleName;

    @Schema(name = "角色编码")
    private String roleCode;

}
