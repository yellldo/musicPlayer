package com.music.player.infra.api.enmus;

import com.music.player.framework.common.support.code.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName : ErrorCodeConstants<br>
 * Description : 错误码枚举类<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeConstants implements IErrorCode {


    DICT_EXISTS("1-001-000-000", "字典项已存在"),

    ;

    final String errorCode;

    final String errorMsg;
}
