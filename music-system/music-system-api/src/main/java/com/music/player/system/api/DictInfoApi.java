package com.music.player.system.api;

import com.music.player.framework.common.base.R;
import com.music.player.framework.common.constants.FeignConstants;
import com.music.player.system.dto.DictInfoListDto;
import com.music.player.system.vo.DictInfoVo;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * ClassName : DictInfoApi<br>
 * Description : DictInfoApi<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@FeignClient(value = FeignConstants.MUSIC_SYSTEM, path = FeignConstants.MUSIC_SYSTEM_URL)
public interface DictInfoApi {

    /**
     * 根据字典type查询字典信息
     *
     * @param dictInfoListDto
     * @return 字典列表
     */
    @PostMapping(FeignConstants.MUSIC_SYSTEM_URL + "/api/dictInfoList")
    R<List<DictInfoVo>> dictInfoList(@Valid @RequestBody DictInfoListDto dictInfoListDto);

}
