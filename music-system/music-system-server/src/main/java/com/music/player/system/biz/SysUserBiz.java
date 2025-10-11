package com.music.player.system.biz;


import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.music.player.system.convert.SysUserConvert;
import com.music.player.system.dto.CreateSysUserDto;
import com.music.player.system.enmus.ErrorCodeConstants;
import com.music.player.system.entity.SysUser;
import com.music.player.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysUserBiz<br>
 * Description : SysUserBiz<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Service
public class SysUserBiz {

    @Value("${}")
    private String defaultPassword;

    @Autowired
    private SysUserService sysUserService;

    public void create(CreateSysUserDto createSysUserDto) {
        long selectCount = sysUserService.selectCount(new LambdaQueryWrapperX<SysUser>()
                .eqIfPresent(SysUser::getLoginName, createSysUserDto.getLoginName())
                .eqIfPresent(SysUser::getIsDelete, CommonConstants.STATUS_NOT_DEL));
        if (selectCount > 0) {
            throw new BusinessException(ErrorCodeConstants.LOGIN_NAME_EXISTS);
        }
        SysUser sysUser = SysUserConvert.INSTANT.create(createSysUserDto);
        sysUser.setPassword(defaultPassword);
        sysUserService.save(sysUser);
    }
}
