package com.music.player.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.auth.api.domain.UserDetails;
import com.music.player.auth.api.dto.JwtUser;
import com.music.player.auth.entity.UserInfo;
import com.music.player.auth.mapper.UserInfoMapper;
import com.music.player.auth.service.UserInfoService;
import com.music.player.framework.common.support.BizException;
import org.springframework.stereotype.Service;

import static com.music.player.auth.api.enums.ErrorCodeConstants.EMAIL_NOT_EXISTS;
import static com.music.player.auth.api.enums.ErrorCodeConstants.PHONE_NOT_EXISTS;

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
            throw new BizException(PHONE_NOT_EXISTS);
        }
        return generateJwtUser(userInfo);
    }

    @Override
    public UserDetails loadUserByEmail(String email) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getEmail, email);
        UserInfo userInfo = baseMapper.selectOne(queryWrapper);
        if (userInfo == null) {
            throw new BizException(EMAIL_NOT_EXISTS);
        }
        return generateJwtUser(userInfo);
    }

    public UserDetails generateJwtUser(UserInfo userInfo) {
        return new JwtUser()
                .setEmail(userInfo.getEmail())
                .setPhone(userInfo.getPhone())
                .setUserStatus(userInfo.getUserStatus())
                .setLoginName(userInfo.getUserName());
    }

}
