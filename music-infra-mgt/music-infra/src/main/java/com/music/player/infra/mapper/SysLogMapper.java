package com.music.player.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.infra.api.dto.QuerySysLogDto;
import com.music.player.infra.api.vo.QuerySysLogVo;
import com.music.player.infra.entity.SysLog;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName : SysLogMapper<br>
 * Description : SysLogMapper<br>
 *
 * @author : sj
 * @date : 2024/5/19
 */
public interface SysLogMapper extends BaseMapper<SysLog> {

    IPage<QuerySysLogVo> querySysLog(Page<QuerySysLogVo> page, @Param("querySysLogDto") QuerySysLogDto querySysLogDto);
}
