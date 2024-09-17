package com.music.player.web.event;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.music.player.framework.common.jackson.MusicJavaTimeModule;
import com.music.player.infra.api.service.log.SysLogServiceApi;
import com.music.player.infra.api.service.log.dto.SaveSysLogDto;
import com.music.player.infra.api.service.log.dto.SysLogDto;
import com.music.player.web.config.MusicLogProperties;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import java.util.Objects;

/**
 * ClassName : SysLogListener<br>
 * Description : 异步监听日志事件<br>
 *
 * @author : sj
 * @date : 2024/9/9
 */
@Slf4j
@Component
public class SysLogListener implements ApplicationListener<SysLogEvent> {


    // new 一个 避免日志脱敏策略影响全局ObjectMapper
    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private SysLogServiceApi sysLogServiceApi;

    @Autowired
    private MusicLogProperties musicLogProperties;

    @Override
    public void onApplicationEvent(SysLogEvent event) {
        SaveSysLogDto sysLogDto = event.getSaveSysLogDto();
        SaveSysLogDto saveLogDto = new SaveSysLogDto();
        BeanUtils.copyProperties(sysLogDto, saveLogDto);

        // json 格式刷参数放在异步中处理，提升性能
        if (Objects.nonNull(sysLogDto)) {
            try {
                String params = objectMapper.writeValueAsString(sysLogDto.getParams());
                saveLogDto.setParams(StrUtil.subPre(params, musicLogProperties.getMaxLength()));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        sysLogServiceApi.saveSysLog(saveLogDto);
    }
}
