package com.music.player.adm.biz;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.music.player.adm.constants.UserRedisConstant;
import com.music.player.adm.convert.SysUserConvert;
import com.music.player.adm.dto.SysUserLoginDto;
import com.music.player.adm.dto.SysUserRegisterDto;
import com.music.player.adm.entity.SysUser;
import com.music.player.adm.enums.ErrorCodeConstants;
import com.music.player.adm.service.SysUserService;
import com.music.player.adm.utils.JwtTokenUtil;
import com.music.player.framework.cache.service.CacheService;
import com.music.player.framework.common.support.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

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
     * User register
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
     * User login
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
        cacheService.set(UserRedisConstant.SYS_USER_KEY + token, SysUserConvert.INSTANT.login(sysUser), Duration.ofMinutes(UserRedisConstant.SYS_USER_LOGIN_EXPIRE));
        return token;
    }

}
