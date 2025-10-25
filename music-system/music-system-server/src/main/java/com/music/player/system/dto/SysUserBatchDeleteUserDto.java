package com.music.player.system.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * ClassName : SysUserBatchDeleteUserDto<br>
 * Description : SysUserBatchDeleteUserDto<br>
 *
 * @author : sj
 * @date : 10/25/25
 */
@Setter
@Getter
@ToString
public class SysUserBatchDeleteUserDto {

    @NotNull(message = "用户列表不能为null")
    @NotEmpty(message = "用户列表不能为空")
    private List<Long> userIdList;
}
