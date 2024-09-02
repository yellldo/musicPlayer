package com.music.player.auth.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.auth.api.enums.ErrorCodeConstants;
import com.music.player.auth.convert.SysUserConvert;
import com.music.player.auth.dto.QuerySysUserListDto;
import com.music.player.auth.dto.SysUserRegisterDto;
import com.music.player.auth.entity.SysUser;
import com.music.player.auth.mapper.SysUserMapper;
import com.music.player.auth.service.SysUserService;
import com.music.player.auth.vo.QuerySysUserListVo;
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
    private SysUserMapper sysUserMapper;


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


    public IPage<QuerySysUserListVo> querySysUserList(QuerySysUserListDto querySysUserListDto) {
        Page<QuerySysUserListVo> page = new Page<>(querySysUserListDto.getPageNum(), querySysUserListDto.getPageSize());
        return sysUserMapper.querySysUserList(page, querySysUserListDto);
    }
}
