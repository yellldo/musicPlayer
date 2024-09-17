package com.music.player.auth.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * ClassName : SaveSysMenuDto<br>
 * Description : SaveSysMenuDto<br>
 *
 * @author : sj
 * @date : 2024/9/12
 */
@Setter
@Getter
@ToString
@ApiModel
public class SaveSysMenuDto implements Serializable {

    @NotBlank(message = "请输入菜单名称")
    private String menuName;

    private Long parentId;

    private String menuUrl;

    @NotBlank(message = "请输入菜单权限")
    private String menuPermission;

    private String menuIcon;

    private Integer level;

    @NotBlank(message = "请选择菜单类型")
    private String menuType;

    private Integer priority;
}
