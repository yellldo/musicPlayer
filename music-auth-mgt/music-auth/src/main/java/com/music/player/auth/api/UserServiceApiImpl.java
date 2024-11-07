package com.music.player.auth.api;

import com.music.player.auth.api.service.user.UserServiceApi;
import com.music.player.auth.api.service.user.dto.GetUserInfoDto;
import com.music.player.auth.api.service.user.dto.RelevanceAuthorDto;
import com.music.player.auth.api.service.user.dto.SaveUserAuthorInfoDto;
import com.music.player.auth.api.service.user.vo.UserInfoVo;
import com.music.player.auth.biz.UserBiz;
import com.music.player.auth.entity.UserAuthorInfo;
import com.music.player.auth.service.UserAuthorInfoService;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : UserServiceApiImpl<br>
 * Description : UserServiceApiImpl<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@RestController
public class UserServiceApiImpl implements UserServiceApi {

    @Autowired
    private UserBiz userBiz;
    @Autowired
    private UserAuthorInfoService userAuthorInfoService;

    @Override
    public R<UserInfoVo> getUserInfo(GetUserInfoDto getUserInfoDto) {
        return R.ok(userBiz.getUserInfo(getUserInfoDto));
    }

    @Override
    public void saveUserAuthorInfo(SaveUserAuthorInfoDto saveUserAuthorInfoDto) {
        UserAuthorInfo userAuthorInfo = new UserAuthorInfo();
        userAuthorInfo.setAuthorId(saveUserAuthorInfoDto.getAuthorId());
        userAuthorInfo.setUserId(userAuthorInfo.getUserId());
        userAuthorInfoService.save(userAuthorInfo);
    }

    @Override
    public void relevanceAuthor(RelevanceAuthorDto relevanceAuthorDto) {

    }
}
