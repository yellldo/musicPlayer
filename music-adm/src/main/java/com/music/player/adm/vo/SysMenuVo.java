package com.music.player.adm.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : SysMenuVo<br>
 * Description : SysMenuVo<br>
 *
 * @author : sj
 * @date : 2024/9/17
 */
@Setter
@Getter
@ToString
public class SysMenuVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long menuId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    private String menuName;

    private String menuStatus;

    private String menuType;

    private String menuIcon;

    private String menuPermission;

    private String menuUrl;

    private Integer level;

    private Integer priority;

}
