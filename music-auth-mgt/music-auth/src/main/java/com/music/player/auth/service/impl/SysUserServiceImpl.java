package com.music.player.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.auth.api.dto.JwtUser;
import com.music.player.auth.entity.SysUser;
import com.music.player.auth.mapper.SysUserMapper;
import com.music.player.auth.service.SysUserService;
import com.music.player.common.exceptions.BusinessException;
import com.music.player.common.exceptions.UserErrorEnum;
import org.springframework.security.core.userdetails.UserDetails;
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
    public UserDetails loadUserByUserName(String userName) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUserName, userName);
        SysUser sysUser = baseMapper.selectOne(queryWrapper);
        if (sysUser == null) {
            throw new BusinessException(UserErrorEnum.USER_NOT_EXISTS);
        }
        return generateJwtUser(sysUser);
    }

    public UserDetails generateJwtUser(SysUser sysUser) {
        return new JwtUser()
                .setUserName(sysUser.getUserName())
                .setUserStatus(sysUser.getUserStatus());
    }
}
