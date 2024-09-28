package com.music.player.infra.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysLogVo<br>
 * Description : SysLogVo<br>
 *
 * @author : sj
 * @date : 2024/9/22
 */
@Setter
@Getter
@ToString
public class SysLogVo {

    private String logType;

    private String userType;

    private String userName;

    private String ip;

    private String requestUri;

    private String method;

    private String params;

    private String exception;

    private String createTime;


}
