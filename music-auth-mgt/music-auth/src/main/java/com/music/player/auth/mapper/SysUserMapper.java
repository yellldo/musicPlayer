package com.music.player.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.auth.dto.QuerySysUserListDto;
import com.music.player.auth.entity.SysUser;
import com.music.player.auth.vo.QuerySysUserListVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName : SysUserMapper.xml<br>
 * Description : SysUserMapper.xml<br>
 *
 * @author : sj
 * @date : 2024/3/20
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    IPage<QuerySysUserListVo> querySysUserList(Page<QuerySysUserListVo> page, @Param("querySysUserListDto") QuerySysUserListDto querySysUserListDto);


}
