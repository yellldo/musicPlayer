package com.music.player.user.api;

import com.music.player.framework.common.base.R;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.user.biz.UserInfoBiz;
import com.music.player.user.dto.QueryUserDto;
import com.music.player.user.dto.UpdateUserArtistFlagDto;
import com.music.player.user.dto.UpdateUserInfoDto;
import com.music.player.user.enmus.ErrorCodeConstants;
import com.music.player.user.vo.UserInfoVo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void updateUserArtistFlag(UpdateUserArtistFlagDto updateUserArtistFlagDto) {
        UserInfoVo userInfoVo = userInfoBiz.findById(updateUserArtistFlagDto.getUserId());
        if (userInfoVo == null) {
            throw new BusinessException(ErrorCodeConstants.USER_NOT_EXISTS);
        }
        UpdateUserInfoDto updateUserInfoDto = new UpdateUserInfoDto().setUserId(updateUserArtistFlagDto.getUserId())
                .setIsArtist(updateUserArtistFlagDto.getIsArtist());
        userInfoBiz.update(updateUserInfoDto);
    }

    @Override
    public R<Map<String, UserInfoVo>> queryUserByUserId(QueryUserDto queryUserDto) {
        Map<String, UserInfoVo> result = new HashMap<>();
        List<Long> userIdList = queryUserDto.getUserIdList();
        if (userIdList != null && !userIdList.isEmpty()) {
            userIdList.forEach(userId -> {
                result.put(String.valueOf(userId), userInfoBiz.findById(userId));
            });
        }
        return R.ok(result);
    }


}
