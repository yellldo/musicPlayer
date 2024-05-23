package com.music.player.infra.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * ClassName : SaveMenuDto<br>
 * Description : SaveMenuDto<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
@Setter
@Getter
@ToString
@Schema(description = "新增菜单")
public class SaveMenuDto implements Serializable {

    @NotBlank(message = "请输入菜单名称")
    @Schema(description = "菜单名称")
    private String menuName;

    @NotBlank(message = "请输入英文名称")
    @Schema(description = "英文名称")
    private String enName;

    @NotBlank(message = "请输入权限标识")
    @Schema(description = "权限标识")
    private String permission;

    @NotBlank(message = "请输入路由路径")
    @Schema(description = "路由路径")
    private String path;

    @Schema(description = "父级id")
    private Long parentId;

    @NotBlank(message = "请输入菜单图标")
    @Schema(description = "菜单图标")
    private String icon;

    @Schema(description = "菜单是否显示")
    private String visible;

    @Schema(description = "排序值")
    private int sortOrder;

    @Schema(description = "菜单类型，0目录，1菜单，2按钮")
    private String menuType;
}
