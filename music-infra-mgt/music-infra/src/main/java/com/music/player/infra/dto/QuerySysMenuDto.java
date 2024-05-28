package com.music.player.infra.dto;

import com.music.player.framework.common.base.QueryRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : QuerySysMenuDto<br>
 * Description : QuerySysMenuDto<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
@Setter
@Getter
@ToString
@Schema(description = "查询菜单dto")
@EqualsAndHashCode(callSuper = true)
public class QuerySysMenuDto extends QueryRequest {

    @Schema(description = "菜单名称")
    private String menuName;

}
