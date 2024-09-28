package com.music.player.infra.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.infra.dto.QuerySysLogDto;
import com.music.player.infra.entity.SysLog;
import com.music.player.infra.vo.SysLogVo;

/**
 * ClassName : SysLogService<br>
 * Description : SysLogService<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
public interface SysLogService extends IService<SysLog> {


    IPage<SysLogVo> querySysLog(QuerySysLogDto querySysLogDto);
}
