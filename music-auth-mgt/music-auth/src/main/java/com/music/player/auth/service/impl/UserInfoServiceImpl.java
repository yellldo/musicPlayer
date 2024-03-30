package com.music.player.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.auth.api.dto.JwtUser;
import com.music.player.auth.entity.UserInfo;
import com.music.player.auth.mapper.UserInfoMapper;
import com.music.player.auth.service.UserInfoService;
import com.music.player.common.exceptions.BusinessException;
import com.music.player.common.exceptions.UserErrorEnum;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * ClassName : UserInfoServiceImpl<br>
 * Description : UserInfoServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {


    @Override
    public UserDetails loadUserByPhone(String phone) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getPhone, phone);
        UserInfo userInfo = baseMapper.selectOne(queryWrapper);
        if (userInfo == null) {
            throw new BusinessException(UserErrorEnum.USER_NOT_EXISTS);
        }
        return generateJwtUser(userInfo);
    }

    @Override
    public UserDetails loadUserByEmail(String email) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getEmail, email);
        UserInfo userInfo = baseMapper.selectOne(queryWrapper);
        if (userInfo == null) {
            throw new BusinessException(UserErrorEnum.USER_NOT_EXISTS);
        }
        return generateJwtUser(userInfo);
    }

    public UserDetails generateJwtUser(UserInfo userInfo) {
        return new JwtUser()
                .setUserName(userInfo.getUserName())
                .setEmail(userInfo.getEmail())
                .setPhone(userInfo.getPhone())
                .setUserStatus(userInfo.getUserStatus());
    }

}
