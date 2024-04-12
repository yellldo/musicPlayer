package com.music.player.framework.web.core.handler;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.map.MapUtil;
import com.music.player.framework.common.domain.CommonResult;
import com.music.player.framework.common.exceptions.ServerException;
import com.music.player.framework.common.exceptions.ServiceException;
import com.music.player.framework.common.exceptions.enums.GlobalErrorCodeConstants;
import com.music.player.framework.common.utils.JsonUtils;
import com.music.player.framework.common.utils.ServletUtils;
import com.music.player.framework.web.core.util.WebFrameworkUtils;
import com.music.player.infra.api.dto.ApiAccessLogCreateReqDto;
import com.music.player.infra.api.service.ApiAccessLogFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * ClassName : GlobalExceptionAdvice<br>
 * Description : 全局异常捕获<br>
 *
 * @author : sj
 * @date : 2024/4/6
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {


    private final ApiAccessLogFeign apiAccessLogFeign;

    private final String applicationName;

    public GlobalExceptionAdvice(String applicationName, ApiAccessLogFeign apiAccessLogFeign) {
        this.applicationName = applicationName;
        this.apiAccessLogFeign = apiAccessLogFeign;
    }

    /**
     * 捕获业务异常
     */
    @ExceptionHandler(value = ServiceException.class)
    public CommonResult processServiceException(HttpServletResponse response, ServiceException exception) {
        log.error(exception.getMessage(), exception);
        // 设置HTTP状态码
        response.setContentType("application/json;charset=UTF-8");
        return CommonResult.error(exception.getCode(), exception.getMessage());
    }

    /**
     * 捕获业务异常
     */
    @ExceptionHandler(value = ServerException.class)
    public CommonResult processServerException(HttpServletResponse response, ServerException exception) {
        log.error(exception.getMessage(), exception);
        // 设置HTTP状态码
        response.setContentType("application/json;charset=UTF-8");
        return CommonResult.error(exception.getCode(), exception.getMessage());
    }

    /**
     * 处理 SpringMVC 参数绑定不正确，本质上也是通过 Validator 校验
     */
    @ExceptionHandler(BindException.class)
    public CommonResult<?> bindExceptionHandler(BindException ex) {
        log.warn("[handleBindException]", ex);
        FieldError fieldError = ex.getFieldError();
        assert fieldError != null; // 断言，避免告警
        return CommonResult.error(GlobalErrorCodeConstants.BAD_REQUEST.getCode(), String.format("请求参数不正确:%s", fieldError.getDefaultMessage()));
    }

    /**
     * 处理 Validator 校验不通过产生的异常
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public CommonResult<?> constraintViolationExceptionHandler(ConstraintViolationException ex) {
        log.warn("[constraintViolationExceptionHandler]", ex);
        ConstraintViolation<?> constraintViolation = ex.getConstraintViolations().iterator().next();
        return CommonResult.error(GlobalErrorCodeConstants.BAD_REQUEST.getCode(), String.format("请求参数不正确:%s", constraintViolation.getMessage()));
    }

    /**
     * 处理 SpringMVC 请求方法不正确
     * <p>
     * 例如说，A 接口的方法为 GET 方式，结果请求方法为 POST 方式，导致不匹配
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult<?> httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex) {
        log.warn("[httpRequestMethodNotSupportedExceptionHandler]", ex);
        return CommonResult.error(GlobalErrorCodeConstants.METHOD_NOT_ALLOWED.getCode(), String.format("请求方法不正确:%s", ex.getMessage()));
    }

    /**
     * 处理系统异常，兜底处理所有的一切
     */
    @ExceptionHandler(value = Exception.class)
    public CommonResult<?> defaultExceptionHandler(HttpServletRequest req, Throwable ex) {
        // 处理异常
        log.error("[defaultExceptionHandler]", ex);
        // 插入异常日志
        createExceptionLog(req, ex);
        // 返回 ERROR CommonResult
        return CommonResult.error(GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR.getCode(), GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR.getMsg());
    }

    private void createExceptionLog(HttpServletRequest req, Throwable e) {
        // 插入错误日志
        ApiAccessLogCreateReqDto errorLog = new ApiAccessLogCreateReqDto();
        try {
            // 初始化 errorLog
            buildExceptionLog(errorLog, req, e);
            // 执行插入 errorLog
            apiAccessLogFeign.createApiAccessLog(errorLog);
        } catch (Throwable th) {
            log.error("[createExceptionLog][url({}) log({}) 发生异常]", req.getRequestURI(), JsonUtils.toJsonString(errorLog), th);
        }
    }

    private void buildExceptionLog(ApiAccessLogCreateReqDto errorLog, HttpServletRequest request, Throwable e) {
        // 处理用户信息
        errorLog.setUserId(WebFrameworkUtils.getLoginUserId(request));
        errorLog.setUserType(WebFrameworkUtils.getLoginUserType(request));
        // 设置异常字段
        errorLog.setExceptionName(e.getClass().getName());
        errorLog.setExceptionMessage(ExceptionUtil.getMessage(e));
        errorLog.setExceptionRootCauseMessage(ExceptionUtil.getRootCauseMessage(e));
        errorLog.setExceptionStackTrace(ExceptionUtil.stacktraceToString(e));
        // 设置其它字段
        errorLog.setRequestUrl(request.getRequestURI());
        errorLog.setApplicationName(applicationName);
        Map<String, Object> requestParams = MapUtil.<String, Object>builder()
                .put("query", ServletUtils.getParamMap(request))
                .put("body", ServletUtils.getBody(request)).build();
        errorLog.setRequestParams(JsonUtils.toJsonString(requestParams));
        errorLog.setRequestMethod(request.getMethod());
        errorLog.setUserAgent(ServletUtils.getUserAgent(request));
        errorLog.setUserIp(ServletUtils.getClientIP(request));
        errorLog.setExceptionTime(LocalDateTime.now());
    }


}
