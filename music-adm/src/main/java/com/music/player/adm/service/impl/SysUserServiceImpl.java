package com.music.player.adm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.adm.dto.JwtUser;
import com.music.player.adm.dto.QuerySysUserListDto;
import com.music.player.adm.entity.SysUser;
import com.music.player.adm.enums.ErrorCodeConstants;
import com.music.player.adm.mapper.SysUserMapper;
import com.music.player.adm.service.SysUserService;
import com.music.player.adm.vo.QuerySysUserListVo;
import com.music.player.adm.vo.UserDetails;
import com.music.player.framework.common.support.BizException;
import org.springframework.stereotype.Service;


/**
 * ClassName : SysUserServiceImpl<br>
 * Description : SysUserServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/3/20
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

    @Override
    public UserDetails loadUserByLoginName(String loginName) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getLoginName, loginName);
        SysUser sysUser = baseMapper.selectOne(queryWrapper);
        if (sysUser == null) {
            throw new BizException(ErrorCodeConstants.SYS_USER_NOT_EXISTS);
        }
        return generateJwtUser(sysUser);
    }

    @Override
    public IPage<QuerySysUserListVo> querySysUserList(QuerySysUserListDto querySysUserListDto) {
        Page<QuerySysUserListVo> page = new Page<>(querySysUserListDto.getPageNum(), querySysUserListDto.getPageSize());
        return baseMapper.querySysUserList(page, querySysUserListDto);
    }

    public UserDetails generateJwtUser(SysUser sysUser) {
        return new JwtUser()
                .setUserStatus(sysUser.getUserStatus())
                .setLoginName(sysUser.getLoginName());
    }
}
