package com.music.player.infra.api.service.log.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ClassName : SaveSysLogDto<br>
 * Description : SaveSysLogDto<br>
 *
 * @author : sj
 * @date : 2024/5/19
 */
@Setter
@Getter
@ToString
@ApiModel
@Accessors(chain = true)
public class SaveSysLogDto implements Serializable {

    /**
     * 日志类型
     */
    @Schema(description = "日志类型")
    private String logType;

    /**
     * 日志标题
     */
    @Schema(description = "日志标题")
    private String title;

    /**
     * 操作IP地址
     */
    @Schema(description = "操作ip地址")
    private String ip;

    /**
     * 请求URI
     */
    @Schema(description = "请求uri")
    private String requestUri;

    /**
     * 操作方式
     */
    @Schema(description = "操作方式")
    private String method;

    @Schema(description = "提交数据")
    private String params;

    /**
     * 执行时间
     */
    @Schema(description = "方法执行时间")
    private Long time;

    /**
     * 异常信息
     */
    @Schema(description = "异常信息")
    private String exception;

    /**
     * 服务ID
     */
    @Schema(description = "应用标识")
    private String serviceId;
}


