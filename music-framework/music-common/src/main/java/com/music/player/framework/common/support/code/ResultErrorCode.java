package com.music.player.framework.common.support.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName : ResultErrorCode<br>
 * Description : 枚举一些常用API操作码<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
@Getter
@AllArgsConstructor
public enum ResultErrorCode implements IErrorCode {

    // 消息不能读取
    MSG_NOT_READABLE("405", "消息不能读取"),
    METHOD_NOT_SUPPORTED("405", "不支持当前请求方法"),
    MEDIA_TYPE_NOT_SUPPORTED("415", "不支持当前媒体类型"),

    // 文件上传异常
    PARAM_MISS("A0410", "请求必填参数为空"),
    PARAM_TYPE_ERROR("A0421", "参数格式不匹配"),
    PARAM_VALID_ERROR("A0415", "参数校验失败"),
    PARAM_EX("A0416", "参数类型解析异常"),
    USERNAME_EMPTY("A0110", "用户名不能为空"),
    PASSWORD_EMPTY("A0120", "密码不能为空"),
    USER_NOT_FOUND("A0201", "用户账户不存在"),
    USER_PASSWORD_ERROR("A0210", "用户密码错误"),
    USER_PASSWORD_LIMIT("A0211", "用户输入密码错误次数超限"),

    //系统相关 start
    FAILURE("B0001", "操作失败"),


    CLUSTER_REDIRECT_EXCEPTION("C0230", "Redis集群异常"),
    CLUSTER_STATE_FAILURE_EXCEPTION("C0230", "Redis集群状态故障异常"),
    REDIS_CONNECTION_FAILURE_EXCEPTION("C0230", "Redis连接失败异常"),
    REDIS_SYSTEM_EXCEPTION("C0230", "Redis系统异常"),
    TOO_MANY_CLUSTER_REDIRECTIONS_EXCEPTION("C0230", "Redis集群重定向过多异常"),
    CLUSTER_COMMAND_EXECUTION_FAILURE_EXCEPTION("C0230", "Redis集群命令执行失败异常"),
    REDIS_SUBSCRIBED_CONNECTION_EXCEPTION("C0230", "Redis订阅连接异常"),

    COMMON_FAILURE("500", "操作失败"),
    //系统相关 end

    ;

    final String errorCode;

    final String errorMsg;
}
