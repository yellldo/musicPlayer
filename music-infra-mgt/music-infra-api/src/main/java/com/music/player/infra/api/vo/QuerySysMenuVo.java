package com.music.player.infra.api.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : QuerySysMenuVo<br>
 * Description : QuerySysMenuVo<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
@Setter
@Getter
@ToString
public class QuerySysMenuVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long menuId;

    private String menuName;

    private String permission;

    private String path;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    private String menuType;
}
