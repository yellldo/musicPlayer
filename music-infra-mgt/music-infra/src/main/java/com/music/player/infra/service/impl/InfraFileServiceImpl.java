package com.music.player.infra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.infra.entity.InfraFile;
import com.music.player.infra.mapper.InfraFileMapper;
import com.music.player.infra.service.InfraFileService;
import org.springframework.stereotype.Service;

/**
 * ClassName : InfraFileServiceImpl<br>
 * Description : InfraFileServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/9/22
 */
@Service
public class InfraFileServiceImpl extends ServiceImpl<InfraFileMapper, InfraFile> implements InfraFileService {
}
