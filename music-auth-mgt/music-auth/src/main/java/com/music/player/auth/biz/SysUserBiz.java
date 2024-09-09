package com.music.player.auth.biz;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.music.player.auth.api.enums.ErrorCodeConstants;
import com.music.player.auth.constants.AuthRedisKey;
import com.music.player.auth.convert.SysUserConvert;
import com.music.player.auth.dto.SysUserLoginDto;
import com.music.player.auth.dto.SysUserRegisterDto;
import com.music.player.auth.entity.SysUser;
import com.music.player.auth.service.SysUserService;
import com.music.player.auth.utils.JwtTokenUtil;
import com.music.player.framework.cache.service.CacheService;
import com.music.player.framework.common.support.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysUserBiz<br>
 * Description : SysUserBiz<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Service
public class SysUserBiz {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    /**
     * 后台用户注册
     *
     * @param sysUserRegisterDto
     */
    public void register(SysUserRegisterDto sysUserRegisterDto) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getLoginName, sysUserRegisterDto.getLoginName());
        long count = sysUserService.count(queryWrapper);
        if (count > 0) {
            throw new BizException(ErrorCodeConstants.SYS_USER_EXISTS);
        }
        SysUser sysUser = SysUserConvert.INSTANT.register(sysUserRegisterDto);
        sysUserService.save(sysUser);
    }

    /**
     * 后台用户登录
     *
     * @param sysUserLoginDto
     * @return token
     */
    public String login(SysUserLoginDto sysUserLoginDto) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getLoginName, sysUserLoginDto.getLoginName());
        SysUser sysUser = sysUserService.getOne(queryWrapper);
        if (sysUser == null) {
            throw new BizException(ErrorCodeConstants.SYS_USER_NOT_EXISTS);
        }
        if (!sysUser.getPassword().equals(sysUserLoginDto.getPassword())) {
            throw new BizException(ErrorCodeConstants.SYS_USER_LOGIN_FAIL);
        }
        // 这里暂时先用UUID代替
        String token = UUID.fastUUID().toString();
        cacheService.set(AuthRedisKey.SYS_USER_KEY + token, SysUserConvert.INSTANT.login(sysUser));
        return token;
    }

}
