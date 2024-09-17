package com.music.player.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * ClassName : RoleRelationMenuDto<br>
 * Description : RoleRelationMenuDto<br>
 *
 * @author : sj
 * @date : 2024/9/17
 */
@Setter
@Getter
@ToString
@ApiModel
public class RoleRelationMenuDto implements Serializable {

    @NotNull(message = "参数异常")
    @ApiModelProperty("角色id")
    private Long roleId;

    @NotNull(message = "参数异常")
    @ApiModelProperty("菜单id列表")
    private List<Long> menuId;

}
