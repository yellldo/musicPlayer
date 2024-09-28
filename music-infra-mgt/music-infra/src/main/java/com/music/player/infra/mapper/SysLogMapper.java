package com.music.player.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.infra.dto.QuerySysLogDto;
import com.music.player.infra.entity.SysLog;
import com.music.player.infra.vo.SysLogVo;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName : SysLogMapper<br>
 * Description : SysLogMapper<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
public interface SysLogMapper extends BaseMapper<SysLog> {

    IPage<SysLogVo> querySysLog(Page<SysLogVo> page, @Param("querySysLogDto") QuerySysLogDto querySysLogDto);
}
