package com.music.player.adm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * ClassName : SaveRoleDto<br>
 * Description : SaveRoleDto<br>
 *
 * @author : sj
 * @date : 2024/9/11
 */
@Setter
@Getter
@ToString
@ApiModel
public class SaveRoleDto implements Serializable {

    @NotBlank(message = "请输入角色名称")
    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色说明")
    private String roleDesc;
}
