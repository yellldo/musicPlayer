package com.music.player.system.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysMenuCreateDto<br>
 * Description : SysMenuCreateDto<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString
public class SysMenuCreateDto {

    private String menuName;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    private Integer level;

    private String menuType;

    private String menuPath;

    private String permission;

    private String isShow;
}
