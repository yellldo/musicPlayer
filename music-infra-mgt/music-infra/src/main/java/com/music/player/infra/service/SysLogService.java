package com.music.player.infra.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.infra.dto.QuerySysLogDto;
import com.music.player.infra.entity.SysLog;
import com.music.player.infra.vo.QuerySysLogVo;

/**
 * ClassName : SysLogService<br>
 * Description : SysLogService<br>
 *
 * @author : sj
 * @date : 2024/5/19
 */
public interface SysLogService extends IService<SysLog> {

    /**
     * 查询日志
     *
     * @param querySysLogDto
     * @return
     */
    IPage<QuerySysLogVo> querySysLog(QuerySysLogDto querySysLogDto);
}
