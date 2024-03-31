package com.music.player.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.music.player.infra.entity.ApiAccessLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName : ApuAccessLogMapper<br>
 * Description : ApuAccessLogMapper<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@Mapper
public interface ApiAccessLogMapper extends BaseMapper<ApiAccessLog> {
}
