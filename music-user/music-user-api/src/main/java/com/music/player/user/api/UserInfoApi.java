package com.music.player.user.api;

import com.music.player.framework.common.base.R;
import com.music.player.framework.common.constants.FeignConstants;
import com.music.player.user.dto.UpdateUserArtistFlagDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName : UserInfoApi<br>
 * Description : UserInfoApi<br>
 *
 * @author : sj
 * @date : 1/10/26
 */
@FeignClient(value = FeignConstants.MUSIC_USER, path = FeignConstants.MUSIC_USER_URL)
public interface UserInfoApi {

    R<Void> updateUserArtistFlag(@RequestBody UpdateUserArtistFlagDto updateUserArtistFlagDto);
}
