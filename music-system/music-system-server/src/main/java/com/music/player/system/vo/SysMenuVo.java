package com.music.player.system.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * ClassName : SysMenuVo<br>
 * Description : SysMenuVo<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class SysMenuVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long menuId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    private String menuName;

    private String menuType;

    private String menuPath;

    public String componentPath;

    private String[] parentIdList;

    private Integer level;

    private String permission;

    private String icon;

    private String menuRemark;

    private List<SysMenuVo> children;
}
