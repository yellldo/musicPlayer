package com.music.player.infra.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.music.player.infra.api.enmus.LogTypeEnums;
import com.music.player.infra.api.enmus.UserTypeEnums;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName : SysLog<br>
 * Description : SysLog<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Setter
@Getter
@ToString
@TableName("sys_log")
public class SysLog implements Serializable {

    @TableId("id")
    private Long id;

    /**
     * 日志类型
     * 枚举 {@link LogTypeEnums}
     */
    @TableField("log_type")
    private String logType;

    /**
     * 用户编号
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 用户类型 {@link UserTypeEnums }
     */
    @TableField("user_type")
    private String userType;

    /**
     * 用户姓名
     * 冗余 因为用户名可以改
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户ip
     */
    @TableField("ip")
    private String ip;

    /**
     * 请求地址
     */
    @TableField("request_uri")
    private String requestUri;

    /**
     * 方法
     */
    @TableField("method")
    private String method;

    /**
     * 入参
     */
    @TableField("params")
    private String params;

    @TableField("exception")
    private String exception;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

}
