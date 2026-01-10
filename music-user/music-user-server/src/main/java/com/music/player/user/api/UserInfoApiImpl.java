package com.music.player.user.api;

import com.music.player.framework.common.base.R;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.user.biz.UserInfoBiz;
import com.music.player.user.dto.UpdateUserArtistFlagDto;
import com.music.player.user.dto.UpdateUserInfoDto;
import com.music.player.user.enmus.ErrorCodeConstants;
import com.music.player.user.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : UserInfoApiImpl<br>
 * Description : UserInfoApiImpl<br>
 *
 * @author : sj
 * @date : 1/10/26
 */
@RestController
public class UserInfoApiImpl implements UserInfoApi {

    @Autowired
    private UserInfoBiz userInfoBiz;

    @Override
    public R<Void> updateUserArtistFlag(UpdateUserArtistFlagDto updateUserArtistFlagDto) {
        UserInfoVo userInfoVo = userInfoBiz.findById(updateUserArtistFlagDto.getUserId());
        if (userInfoVo == null) {
            throw new BusinessException(ErrorCodeConstants.USER_NOT_EXISTS);
        }
        UpdateUserInfoDto updateUserInfoDto = new UpdateUserInfoDto().setUserId(updateUserArtistFlagDto.getUserId())
                .setIsArtist(updateUserArtistFlagDto.getIsArtist());
        userInfoBiz.update(updateUserInfoDto);
        return R.ok();
    }
}
