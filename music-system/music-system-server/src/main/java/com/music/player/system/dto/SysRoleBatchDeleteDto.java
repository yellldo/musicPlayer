package com.music.player.system.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * ClassName : SysRoleBatchDeleteDto<br>
 * Description : SysRoleBatchDeleteDto<br>
 *
 * @author : sj
 * @date : 10/25/25
 */
@Setter
@Getter
@ToString
public class SysRoleBatchDeleteDto {

    @NotNull(message = "角色id列表不能为null")
    @NotEmpty(message = "角色id列表不能为空")
    private List<Long> roleIdList;
}
