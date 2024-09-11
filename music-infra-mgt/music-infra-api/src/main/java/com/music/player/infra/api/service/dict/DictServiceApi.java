package com.music.player.infra.api.service.dict;

import com.music.player.framework.common.base.R;
import com.music.player.infra.api.enmus.ApiConstants;
import com.music.player.infra.api.service.dict.dto.QueryDictListDto;
import com.music.player.infra.api.service.dict.vo.DictInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * ClassName : DictServiceApi<br>
 * Description : DictServiceApi<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@FeignClient(value = ApiConstants.NAME, path = ApiConstants.PATH)
public interface DictServiceApi {


    @GetMapping("queryDictList")
    R<List<DictInfoVo>> queryDictList(QueryDictListDto queryDictListDto);

}
