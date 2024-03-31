package com.music.player.infra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.infra.entity.ApiAccessLog;
import com.music.player.infra.mapper.ApiAccessLogMapper;
import com.music.player.infra.service.ApiAccessLogService;
import org.springframework.stereotype.Service;

/**
 * ClassName : ApiAccessLogServiceImpl<br>
 * Description : ApiAccessLogServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@Service
public class ApiAccessLogServiceImpl extends ServiceImpl<ApiAccessLogMapper, ApiAccessLog>
        implements ApiAccessLogService {


}
