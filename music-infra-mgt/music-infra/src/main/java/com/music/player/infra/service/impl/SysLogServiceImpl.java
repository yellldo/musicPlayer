package com.music.player.infra.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.infra.api.dto.QuerySysLogDto;
import com.music.player.infra.api.vo.QuerySysLogVo;
import com.music.player.infra.entity.SysLog;
import com.music.player.infra.mapper.SysLogMapper;
import com.music.player.infra.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysLogServiceImpl<br>
 * Description : SysLogServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/5/19
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Override
    public IPage<QuerySysLogVo> querySysLog(QuerySysLogDto querySysLogDto) {
        Page<QuerySysLogVo> page = new Page<>(querySysLogDto.getPageNum(), querySysLogDto.getPageSize());
        return baseMapper.querySysLog(page, querySysLogDto);
    }
}
