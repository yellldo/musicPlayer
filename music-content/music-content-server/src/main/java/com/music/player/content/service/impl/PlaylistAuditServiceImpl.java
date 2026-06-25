package com.music.player.content.service.impl;

import com.music.player.content.entity.PlaylistAudit;
import com.music.player.content.mapper.PlaylistAuditMapper;
import com.music.player.content.service.PlaylistAuditService;
import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * ClassName : PlaylistAuditServiceImpl<br>
 * Description : PlaylistAuditServiceImpl<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Service
public class PlaylistAuditServiceImpl extends BaseServiceImpl<PlaylistAuditMapper, PlaylistAudit> implements PlaylistAuditService {
}
