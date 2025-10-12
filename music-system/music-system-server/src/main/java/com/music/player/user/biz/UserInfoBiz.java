package com.music.player.user.biz;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.R;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.id.utils.IdUtils;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.music.player.user.convert.UserInfoConvert;
import com.music.player.user.dto.UpdateUserInfoDto;
import com.music.player.user.dto.UserInfoIdDto;
import com.music.player.user.dto.UserInfoPageDto;
import com.music.player.user.enmus.ErrorCodeConstants;
import com.music.player.user.entity.UserInfo;
import com.music.player.user.service.UserInfoService;
import com.music.player.user.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName : UserInfoBiz<br>
 * Description : UserInfoBiz<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@DS("user")
@Service
public class UserInfoBiz {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private IdUtils idUtils;


    public PageResult<UserInfoVo> page(UserInfoPageDto userInfoPageDto) {
        PageResult<UserInfo> result = userInfoService.selectPage(userInfoPageDto, new LambdaQueryWrapperX<UserInfo>()
                .eqIfPresent(UserInfo::getUserStatus, userInfoPageDto.getUserStatus())
                .eqIfPresent(UserInfo::getUserType, userInfoPageDto.getUserType()));
        return UserInfoConvert.INSTANT.convertPage(result);
    }

    public void update(UpdateUserInfoDto updateUserInfoDto) {
        UserInfo userInfo = userInfoService.getById(updateUserInfoDto.getUserId());
        if (userInfo == null) {
            throw new BusinessException(ErrorCodeConstants.USER_NOT_EXISTS);
        }
        userInfoService.updateById(UserInfoConvert.INSTANT.update(updateUserInfoDto));
    }


    public void delete(UserInfoIdDto userInfoIdDto) {
        UserInfo userInfo = new UserInfo().setUserId(userInfoIdDto.getUserId());
        userInfo.setIsDelete(CommonConstants.STATUS_DEL);
        userInfoService.updateById(userInfo);
    }
}
