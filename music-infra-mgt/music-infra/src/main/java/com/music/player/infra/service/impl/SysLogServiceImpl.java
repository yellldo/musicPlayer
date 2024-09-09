package com.music.player.infra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.infra.entity.SysLog;
import com.music.player.infra.mapper.SysLogMapper;
import com.music.player.infra.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysLogServiceImpl<br>
 * Description : SysLogServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */

@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
}
