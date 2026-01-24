package com.music.player.user.api;

import com.music.player.framework.common.base.R;
import com.music.player.framework.common.constants.FeignConstants;
import com.music.player.framework.feign.decoder.CustomErrorDecoder;
import com.music.player.user.dto.QueryUserDto;
import com.music.player.user.dto.UpdateUserArtistFlagDto;
import com.music.player.user.vo.UserInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * ClassName : UserInfoApi<br>
 * Description : UserInfoApi<br>
 *
 * @author : sj
 * @date : 1/10/26
 */
@FeignClient(value = FeignConstants.MUSIC_USER, path = FeignConstants.MUSIC_USER_URL, configuration = CustomErrorDecoder.class)
public interface UserInfoApi {

    @PostMapping(FeignConstants.MUSIC_USER_URL + "/api/updateUserArtistFlag")
    void updateUserArtistFlag(@RequestBody UpdateUserArtistFlagDto updateUserArtistFlagDto);

    @PostMapping(FeignConstants.MUSIC_USER_URL + "/api/queryUserByUserId")
    R<Map<String, UserInfoVo>> queryUserByUserId(@RequestBody QueryUserDto queryUserDto);
}
