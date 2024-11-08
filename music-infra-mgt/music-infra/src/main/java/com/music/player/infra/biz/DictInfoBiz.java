package com.music.player.infra.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.music.player.framework.common.constant.CommonConstants;
import com.music.player.framework.common.support.BizException;
import com.music.player.framework.common.util.TokenUtil;
import com.music.player.infra.api.enmus.ErrorCodeConstants;
import com.music.player.infra.api.service.dict.dto.QueryDictListDto;
import com.music.player.infra.api.service.dict.vo.DictInfoVo;
import com.music.player.infra.convert.DictInfoConvert;
import com.music.player.infra.dto.DeleteDictDto;
import com.music.player.infra.dto.ModifyDictInfoDto;
import com.music.player.infra.dto.SaveDictInfoDto;
import com.music.player.infra.entity.DictInfo;
import com.music.player.infra.service.DictInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ClassName : DictInfoBiz<br>
 * Description : DictInfoBiz<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@Service
public class DictInfoBiz {

    @Autowired
    private DictInfoService dictInfoService;

    /**
     * Add a dict
     */
    public void saveDictInfo(SaveDictInfoDto saveDictInfoDto, HttpServletRequest request) {
        String token = TokenUtil.getToken(request);
        LambdaQueryWrapper<DictInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DictInfo::getDictKey, saveDictInfoDto.getDictKey());
        queryWrapper.eq(DictInfo::getDictType, saveDictInfoDto.getDictType());
        queryWrapper.eq(DictInfo::getDictValue, saveDictInfoDto.getDictValue());
        queryWrapper.eq(DictInfo::getIsDelete, CommonConstants.STATUS_NOT_DEL);
        long count = dictInfoService.count(queryWrapper);
        if (count > 0) {
            throw new BizException(ErrorCodeConstants.DICT_EXISTS);
        }
        DictInfo dictInfo = DictInfoConvert.INSTANT.saveDictInfo(saveDictInfoDto);
        dictInfoService.save(dictInfo);
    }

    /**
     * Delete the dict based on the condition
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteDict(DeleteDictDto deleteDictDto) {
        // 更新父级字典删除状态
        DictInfo dictInfo = new DictInfo();
        dictInfo.setId(deleteDictDto.getId());
        dictInfo.setIsDelete(CommonConstants.STATUS_DEL);
        dictInfoService.updateById(dictInfo);
        // 更新子级字典删除状态
        LambdaUpdateWrapper<DictInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(DictInfo::getParentId, deleteDictDto.getId());
        updateWrapper.set(DictInfo::getIsDelete, CommonConstants.STATUS_DEL);
        dictInfoService.update(updateWrapper);
    }

    /**
     * Update dict information
     */
    public void modifyDictInfo(ModifyDictInfoDto modifyDictInfoDto) {
        DictInfo dictInfo = DictInfoConvert.INSTANT.modifyDictInfo(modifyDictInfoDto);
        dictInfoService.updateById(dictInfo);
    }

    /**
     * Query the list of dict
     */
    public List<DictInfoVo> queryDictList(QueryDictListDto queryDictListDto) {
        return dictInfoService.queryDictList(queryDictListDto);
    }

}
