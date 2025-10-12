package com.music.player.user.utils;

import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.common.utils.SpringContextUtil;
import com.music.player.user.dto.CreateUserLoginLogDto;
import com.music.player.user.enmus.ErrorCodeConstants;
import com.music.player.user.event.UserLoginLogEvent;

/**
 * ClassName : LogUtils<br>
 * Description : LogUtils<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
public class LogUtils {


    public static void publishLoginLog(CreateUserLoginLogDto logDto, String isSuccess) {
        logDto.setIsSuccess(isSuccess);
        SpringContextUtil.publishEvent(new UserLoginLogEvent(logDto));
    }

    public static void publishAndThrow(CreateUserLoginLogDto logDto, String isSuccess, ErrorCodeConstants errorCode) {
        publishLoginLog(logDto, isSuccess);
        throw new BusinessException(errorCode);
    }
}
