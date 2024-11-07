package com.music.player.adm.rest;

import com.music.player.framework.common.base.R;
import com.music.player.infra.api.service.dict.DictServiceApi;
import com.music.player.infra.api.service.dict.dto.QueryDictListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dict")
public class DictCtrl {

    @Autowired
    private DictServiceApi dictServiceApi;

    /**
     * Obtain the dict list
     * return dict list by page
     */
    @GetMapping("queryDictList")
    public R queryDictList(QueryDictListDto queryDictListDto) {
        return dictServiceApi.queryDictList(queryDictListDto);
    }

}
