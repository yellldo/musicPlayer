package com.music.player.system.mapper;

import com.music.player.framework.mybatis.core.mapper.CommonMapper;
import com.music.player.system.entity.SysMenu;
import com.music.player.system.vo.SysMenuVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName : SysMenuMapper<br>
 * Description : SysMenuMapper<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
public interface SysMenuMapper extends CommonMapper<SysMenu> {


    @Select(" select sm.* from sys_user_role sur  " +
            " inner join sys_role_menu srm on sur.role_id  = srm.role_id " +
            " inner join sys_menu sm on sm.menu_id  = srm.menu_id " +
            " where sur.user_id = #{userId} ")
    List<SysMenuVo> queryMenusByUserId(@Param("userId") Long userId);
}
