package com.music.player.system.vo;

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

    private Long menuId;

    private Long parentId;

    private String menuName;

    private String menuType;

    private String menuPath;

    private Integer level;

    private String icon;

    private String isShow;

    private List<SysMenuVo> child;
}
