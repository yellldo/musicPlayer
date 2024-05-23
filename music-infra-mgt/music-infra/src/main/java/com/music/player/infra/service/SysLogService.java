package com.music.player.infra.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.infra.api.dto.QuerySysLogDto;
import com.music.player.infra.api.vo.QuerySysLogVo;
import com.music.player.infra.entity.SysLog;

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
     * @param sysLogDto
     * @return
     */
    IPage<QuerySysLogVo> querySysLog(QuerySysLogDto sysLogDto);
}
