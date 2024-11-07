package com.music.player.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.music.player.auth.bo.UserTypeAuthorBo;
import com.music.player.auth.bo.UserTypeBaseBo;
import com.music.player.auth.constants.AuthConstants;
import com.music.player.auth.entity.UserAuthorInfo;
import com.music.player.auth.service.UserAuthorInfoService;
import com.music.player.auth.service.UserTypeStrategy;
import com.music.player.chief.api.service.author.AuthorInfoServiceApi;
import com.music.player.chief.api.service.author.dto.FetchAuthorInfoDto;
import com.music.player.chief.api.service.author.vo.FetchAuthorInfoVo;
import com.music.player.framework.common.base.R;
import com.music.player.framework.common.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName : UserTypeAuthorStrategy<br>
 * Description : 根据用户类型获取用户信息策略接口<br>
 *
 * @author : sj
 * @date : 2024/11/7
 */
@Service
public class UserTypeAuthorStrategy implements UserTypeStrategy {

    @Autowired
    private UserAuthorInfoService userAuthorInfoService;
    @Autowired
    private AuthorInfoServiceApi authorInfoServiceApi;

    @Override
    public String userType() {
        return AuthConstants.USER_TYPE_AUTHOR;
    }

    @Override
    public UserTypeBaseBo getUserInfo(Long userId) {
        UserTypeAuthorBo userTypeAuthorBo = new UserTypeAuthorBo();
        LambdaQueryWrapper<UserAuthorInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserAuthorInfo::getUserId, userId);
        queryWrapper.eq(UserAuthorInfo::getIsDelete, "");
        UserAuthorInfo userAuthorInfo = userAuthorInfoService.getOne(queryWrapper);
        FetchAuthorInfoDto fetchAuthorInfoDto = new FetchAuthorInfoDto()
                .setId(userAuthorInfo.getAuthorId());
        R<FetchAuthorInfoVo> result = authorInfoServiceApi.fetchAuthorInfo(fetchAuthorInfoDto);
        if (ResultUtil.checkResult(result)) {
            return ResultUtil.getData(result, userTypeAuthorBo);
        }
        return null;
    }
}
