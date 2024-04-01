package com.music.player.infra.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * ClassName : ApiAccessLog<br>
 * Description : ApiAccessLog<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@Setter
@Getter
@ToString
@TableName("infra_api_access_log")
public class ApiAccessLog {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 链路追踪编号
     * <p>
     * 一般来说，通过链路追踪编号，可以将访问日志，错误日志，链路追踪日志，logger 打印日志等，结合在一起，从而进行排错。
     */
    @TableField("trace_id")
    private String traceId;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 用户类型
     * <p>
     * 枚举 {@link com.music.player.framework.common.enmus.UserTypeEnum}
     */
    private String userType;
    /**
     * 应用名
     * <p>
     * 目前读取 `spring.application.name` 配置项
     */
    private String applicationName;

    // ========== 请求相关字段 ==========

    /**
     * 请求方法名
     */
    private String requestMethod;
    /**
     * 访问地址
     */
    private String requestUrl;
    /**
     * 请求参数
     * <p>
     * query: Query String
     * body: Quest Body
     */
    private String requestParams;
    /**
     * 用户 IP
     */
    private String userIp;
    /**
     * 浏览器 UA
     */
    private String userAgent;

    // ========== 执行相关字段 ==========

    /**
     * 开始请求时间
     */
    private LocalDateTime beginTime;
    /**
     * 结束请求时间
     */
    private LocalDateTime endTime;
    /**
     * 执行时长，单位：毫秒
     */
    private Integer duration;
    /**
     * 结果码
     * <p>
     * 目前使用的 {@link com.music.player.framework.common.domain.CommonResult#getCode()} 属性
     */
    private Integer resultCode;
    /**
     * 结果提示
     * <p>
     * 目前使用的 {@link com.music.player.framework.common.domain.CommonResult#getMsg()} 属性
     */
    private String resultMsg;

}
