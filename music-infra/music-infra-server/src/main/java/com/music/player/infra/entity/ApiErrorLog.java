package com.music.player.infra.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * ClassName : ApiErrorLog<br>
 * Description : ApiErrorLog<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@Setter
@Getter
@ToString
@TableName("infra_api_error_log")
public class ApiErrorLog {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "user_type")
    private String userType;

    @TableField(value = "trace_id")
    private String traceId;

    @TableField(value = "application_name")
    private String applicationName;

    @TableField(value = "request_url")
    private String requestUrl;

    @TableField(value = "request_param")
    private String requestParam;

    @TableField(value = "request_method")
    private String requestMethod;

    @TableField(value = "exception_name")
    private String exceptionName;

    @TableField(value = "exception_time")
    private LocalDateTime exceptionTime;

    @TableField(value = "exception_message")
    private String exceptionMessage;

    @TableField(value = "exception_root_cause_message")
    private String exceptionRootCauseMessage;

    @TableField(value = "exception_class_name")
    private String exceptionClassName;

    @TableField(value = "exception_method_name")
    private String exceptionMethodName;
}
