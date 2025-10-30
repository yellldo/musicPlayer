package com.music.player.system.biz;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.redis.domain.RedisOps;
import com.music.player.system.constants.RedisConstants;
import com.music.player.system.convert.SysUserConvert;
import com.music.player.system.dto.LoginDto;
import com.music.player.system.enmus.ErrorCodeConstants;
import com.music.player.system.entity.SysUser;
import com.music.player.system.service.SysUserService;
import com.music.player.system.vo.LoginVo;
import com.music.player.system.vo.SysUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * ClassName : AuthBiz<br>
 * Description : AuthBiz<br>
 *
 * @author : sj
 * @date : 10/14/25
 */
@Slf4j
@Service
public class AuthBiz {


    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private RedisOps redisOps;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    public LoginVo login(LoginDto loginDto) {
        SysUser sysUser = sysUserService.selectOne(SysUser::getLoginName, loginDto.getUserName(), SysUser::getIsDelete, CommonConstants.STATUS_NOT_DEL);

        if (BeanUtil.isEmpty(sysUser)) {
            throw new BusinessException(ErrorCodeConstants.USER_NOT_EXISTS);
        }

        LoginVo loginVo = new LoginVo();

//        if (CommonConstants.STATUS_RESET.equals(sysUser.getIsReset())) {
//            loginVo.setIsReset(sysUser.getIsReset());
//            return loginVo;
//        }

        String userStatus = sysUser.getUserStatus();

        if (!CommonConstants.USER_STATUS_NORMAL.equals(userStatus)) {
            throw new BusinessException(ErrorCodeConstants.USER_STATUS_ABNORMAL);
        }

        String password = SecureUtil.md5(loginDto.getPassword());
        if (!password.equals(sysUser.getPassword())) {
            int errorCount = sysUser.getErrorCount() + 1;
            updateUserErrorCount(sysUser.getUserId(), errorCount);
            if (CommonConstants.PWD_MAX_ERROR_COUNT == errorCount) {
                throw new BusinessException(ErrorCodeConstants.PASSWORD_ERROR);
            } else {
                throw new BusinessException(ErrorCodeConstants.PASSWORD_ERROR);
            }
        }


        StpUtil.login(sysUser.getUserId());

        loginVo.setToken(StpUtil.getTokenValue());

        SysUserVo sysUserVo = SysUserConvert.INSTANT.copy(sysUser);

        log.info("存入的对象类型: {}", (sysUserVo != null ? sysUserVo.getClass() : "null"));
        redisOps.setEx(RedisConstants.INFO + sysUser.getUserId(), sysUserVo, RedisConstants.ONE_DAY);

        return loginVo;
    }

    private void updateUserErrorCount(Long userId, int errorCount) {
        sysUserService.updateById(new SysUser().setUserId(userId).setErrorCount(errorCount));
    }
}
