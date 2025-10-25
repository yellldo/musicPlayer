package com.music.player.system.biz;


import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.music.player.system.convert.SysUserConvert;
import com.music.player.system.dto.*;
import com.music.player.system.enmus.ErrorCodeConstants;
import com.music.player.system.entity.SysUser;
import com.music.player.system.entity.SysUserRole;
import com.music.player.system.service.SysUserRoleService;
import com.music.player.system.service.SysUserService;
import com.music.player.system.vo.SysUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Transactional(rollbackFor = Exception.class)
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

        Long userId = sysUser.getUserId();

        List<Long> roleIdList = createSysUserDto.getRoleList();
        if (roleIdList != null && !roleIdList.isEmpty()) {
            List<SysUserRole> sysUserRoleList = new ArrayList<>();
            roleIdList.forEach(roleId -> {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setRoleId(roleId);
                sysUserRole.setUserId(userId);
                sysUserRoleList.add(sysUserRole);
            });
            sysUserRoleService.saveBatch(sysUserRoleList);
        }
    }


    public PageResult<SysUserVo> page(SysUserPageDto sysUserPageDto) {
        PageResult<SysUser> sysUserPageResult = sysUserService.selectPage(sysUserPageDto, new LambdaQueryWrapperX<SysUser>()
                .eqIfPresent(SysUser::getUserStatus, sysUserPageDto.getUserStatus())
                .eqIfPresent(SysUser::getLoginName, sysUserPageDto.getLoginName())
                .eqIfPresent(SysUser::getIsDelete, CommonConstants.STATUS_NOT_DEL));

        PageResult<SysUserVo> sysUserVoPageResult = SysUserConvert.INSTANT.convertPage(sysUserPageResult);

        // 3. 提取所有用户ID（只有当有用户数据时才查角色）
        List<SysUserVo> userList = sysUserVoPageResult.getList();
        if (CollectionUtils.isEmpty(userList)) {
            return sysUserVoPageResult;
        }

        List<Long> userIds = userList.stream()
                .map(SysUserVo::getUserId)
                .toList();

        // 4. 【优化重点】一次性查询所有用户关联的角色（按用户ID分组）
        List<SysUserRole> allUserRoles = sysUserRoleService.selectList(
                new LambdaQueryWrapper<SysUserRole>()
                        .in(SysUserRole::getUserId, userIds)
                        .select(SysUserRole::getUserId, SysUserRole::getRoleId)
        );

        // 5. 按 userId 分组，构建 Map<UserId, List<Long>>
        Map<Long, List<String>> userRoleMap = allUserRoles.stream()
                .collect(Collectors.groupingBy(
                        SysUserRole::getUserId,
                        Collectors.mapping(userRole -> userRole.getRoleId().toString(), Collectors.toList())
                ));

        // 6. 给每个 SysUserVo 设置角色列表
        userList.forEach(sysUserVo -> {
            Long userId = sysUserVo.getUserId();
            List<String> roleList = userRoleMap.getOrDefault(userId, Collections.emptyList());
            sysUserVo.setRoleList(roleList);
        });

        return sysUserVoPageResult;
    }

    public void update(SysUserUpdateDto sysUserUpdateDto) {
        Long userId = sysUserUpdateDto.getUserId();
        checkUserExistsByUserId(userId);

        SysUser update = SysUserConvert.INSTANT.update(sysUserUpdateDto);
        sysUserService.updateById(update);

        List<Long> roleIdList = sysUserUpdateDto.getRoleList();
        if (roleIdList != null && !roleIdList.isEmpty()) {

            //  先删后存
            sysUserRoleService.remove(new LambdaQueryWrapperX<SysUserRole>()
                    .eq(SysUserRole::getUserId, userId));

            List<SysUserRole> sysUserRoleList = new ArrayList<>();
            roleIdList.forEach(roleId -> {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setRoleId(roleId);
                sysUserRole.setUserId(userId);
                sysUserRoleList.add(sysUserRole);
            });
            sysUserRoleService.saveBatch(sysUserRoleList);
        }
    }

    public void batchDeleteUser(SysUserBatchDeleteUserDto sysUserBatchDeleteUserDto) {
        List<Long> userIdList = sysUserBatchDeleteUserDto.getUserIdList();
        if (userIdList == null || userIdList.isEmpty()) {
            log.info("user id list is empty");
            return;
        }

        SysUser sysUser = new SysUser();
        sysUser.setIsDelete(CommonConstants.STATUS_DEL);
        sysUserService.update(sysUser, new LambdaQueryWrapperX<SysUser>().in(SysUser::getUserId, userIdList));
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
                .setUserId(sysUserUpdatePwdDto.getUserId())
                .setIsReset(CommonConstants.STATUS_NOT_RESET);
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
