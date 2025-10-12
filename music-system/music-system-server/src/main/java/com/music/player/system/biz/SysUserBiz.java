package com.music.player.system.biz;


import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.music.player.system.convert.SysUserConvert;
import com.music.player.system.dto.*;
import com.music.player.system.enmus.ErrorCodeConstants;
import com.music.player.system.entity.SysUser;
import com.music.player.system.service.SysUserService;
import com.music.player.system.vo.SysUserVo;
import lombok.extern.slf4j.Slf4j;
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
@DS("system")
@Slf4j
@Service
public class SysUserBiz {

    @Value("${user.default-password:1234567}")
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
        sysUser.setPassword(SecureUtil.md5(defaultPassword));
        sysUser.setIsReset(CommonConstants.STATUS_RESET);
        sysUserService.save(sysUser);
    }


    public PageResult<SysUserVo> page(SysUserPageDto sysUserPageDto) {
        PageResult<SysUser> sysUserPageResult = sysUserService.selectPage(sysUserPageDto, new LambdaQueryWrapperX<SysUser>()
                .eqIfPresent(SysUser::getUserStatus, sysUserPageDto.getUserStatus())
                .eqIfPresent(SysUser::getLoginName, sysUserPageDto.getLoginName())
                .eqIfPresent(SysUser::getIsDelete, CommonConstants.STATUS_NOT_DEL));
        return SysUserConvert.INSTANT.convertPage(sysUserPageResult);
    }

    public void update(SysUserUpdateDto sysUserUpdateDto) {
        checkUserExistsByUserId(sysUserUpdateDto.getUserId());

        SysUser update = SysUserConvert.INSTANT.update(sysUserUpdateDto);
        sysUserService.updateById(update);
    }

    public void resetPwd(SysUserResetPwdDto sysUserResetPwdDto) {
        checkUserExistsByUserId(sysUserResetPwdDto.getUserId());

        SysUser sysUser = SysUserConvert.INSTANT.resetPwd(sysUserResetPwdDto);
        sysUser.setPassword(SecureUtil.md5(defaultPassword));
        sysUser.setIsReset(CommonConstants.STATUS_RESET);
        sysUserService.updateById(sysUser);
    }

    public void updatePwd(SysUserUpdatePwdDto sysUserUpdatePwdDto) {
        checkUserExistsByUserId(sysUserUpdatePwdDto.getUserId());

        SysUser sysUser = new SysUser().setIsReset(CommonConstants.STATUS_RESET)
                .setErrorCount(CommonConstants.PWD_ERROR_COUNT)
                .setPassword(SecureUtil.md5(sysUserUpdatePwdDto.getPassword()))
                .setUserId(sysUserUpdatePwdDto.getUserId());
        sysUserService.updateById(sysUser);
    }


    public void updateStatus(SysUserUpdateStatusDto sysUserUpdateStatusDto) {
        if (StrUtil.isEmpty(sysUserUpdateStatusDto.getUserStatus())) {
            log.warn("[userStatus]未传值，不进行操作");
            return;
        }

        checkUserExistsByUserId(sysUserUpdateStatusDto.getUserId());

        if (!CommonConstants.USER_STATUS_LOCKED.equals(sysUserUpdateStatusDto.getUserStatus()) && !CommonConstants.USER_STATUS_NORMAL.equals(sysUserUpdateStatusDto.getUserStatus())) {
            throw new BusinessException(GlobalErrorCodeConstants.PARAM_ERROR);
        }

        SysUser sysUser = new SysUser().setUserId(sysUserUpdateStatusDto.getUserId()).setUserStatus(sysUserUpdateStatusDto.getUserStatus());
        sysUserService.updateById(sysUser);
    }

    public void deleteUser(SysUserDeleteUserDto sysUserDeleteUserDto) {
        checkUserExistsByUserId(sysUserDeleteUserDto.getUserId());

        SysUser sysUser = new SysUser().setUserId(sysUserDeleteUserDto.getUserId());
        sysUser.setIsDelete(CommonConstants.STATUS_DEL);
        sysUserService.updateById(sysUser);
    }

    /**
     * 根据用户id检查用户是否存在，不存在会抛出异常
     *
     * @param userId
     */
    private void checkUserExistsByUserId(Long userId) {
        long count = sysUserService.selectCount(new LambdaQueryWrapperX<SysUser>()
                .eq(SysUser::getUserId, userId)
                .eq(SysUser::getIsDelete, CommonConstants.STATUS_NOT_DEL));
        if (count < 1) {
            throw new BusinessException(ErrorCodeConstants.USER_NOT_EXISTS);
        }
    }
}
