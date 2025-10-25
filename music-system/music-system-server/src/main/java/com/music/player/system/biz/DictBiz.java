package com.music.player.system.biz;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.R;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.music.player.framework.redis.domain.RedisOps;
import com.music.player.system.constants.RedisConstants;
import com.music.player.system.convert.DictConvert;
import com.music.player.system.dto.*;
import com.music.player.system.enmus.ErrorCodeConstants;
import com.music.player.system.entity.DictDetail;
import com.music.player.system.entity.DictInfo;
import com.music.player.system.service.DictDetailService;
import com.music.player.system.service.DictInfoService;
import com.music.player.system.vo.DictDetailVo;
import com.music.player.system.vo.DictInfoVo;
import com.music.player.system.vo.DictCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * ClassName : DictBiz<br>
 * Description : DictBiz<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@DS("system")
@Service
public class DictBiz {

    @Autowired
    private DictInfoService dictInfoService;
    @Autowired
    private DictDetailService dictDetailService;
    @Autowired
    private RedisOps redisOps;

    public void create(CreateDictDto createDictDto) {
        dictInfoService.save(DictConvert.INSTANT.create(createDictDto));
    }

    public R<PageResult<DictCodeVo>> dictCodePage(DictCodePageDto dictCodePageDto) {
        PageResult<DictInfo> result = dictInfoService.selectPage(dictCodePageDto, new LambdaQueryWrapperX<DictInfo>()
                .eqIfPresent(DictInfo::getDictType, dictCodePageDto.getDictType())
                .eq(DictInfo::getIsDelete, CommonConstants.STATUS_NOT_DEL));
        return R.ok(DictConvert.INSTANT.convertDictTypePage(result));
    }

    public void createDictCode(DictCodeCreateDto dictCodeCreateDto) {
        long count = dictInfoService.selectCount(new LambdaQueryWrapperX<DictInfo>()
                .eq(DictInfo::getIsDelete, CommonConstants.STATUS_NOT_DEL)
                .eq(DictInfo::getDictType, dictCodeCreateDto.getDictType())
                .eq(DictInfo::getDictCode, dictCodeCreateDto.getDictCode()));

        if (count > 0) {
            throw new BusinessException(ErrorCodeConstants.DICT_TYPE_EXISTS);
        }

        DictInfo dictInfo = DictConvert.INSTANT.createDictCode(dictCodeCreateDto);
        dictInfo.setCreateBy(StpUtil.getLoginIdAsLong());
        dictInfoService.save(dictInfo);
    }

    public void updateDictCode(UpdateDictDto updateDictDto) {
        DictInfo dictInfo = dictInfoService.getById(updateDictDto.getId());
        if (BeanUtil.isEmpty(dictInfo)) {
            throw new BusinessException(ErrorCodeConstants.DICT_NOT_EXISTS);
        }
        String dictType = dictInfo.getDictType();
        String key = RedisConstants.DICT_KEY + dictType;
        redisOps.del(key);
        dictInfo = DictConvert.INSTANT.update(updateDictDto);
        dictInfoService.updateById(dictInfo);
        redisOps.del(key);
    }

    public void updateStatus(DictUpdateStatusDto dictUpdateStatusDto) {
        DictInfo dictInfo = DictConvert.INSTANT.updateStatus(dictUpdateStatusDto);
        dictInfoService.updateById(dictInfo);
    }

    public void updateDetailStatus(DictUpdateStatusDto dictUpdateStatusDto) {
        DictDetail dictDetail = DictConvert.INSTANT.updateDetailStatus(dictUpdateStatusDto);
        dictDetailService.updateById(dictDetail);
    }

    @Transactional
    public void dictCodeDelete(DictCodeIdDto dictCodeIdDto) {
        DictInfo dictInfo = new DictInfo();
        dictInfo.setIsDelete(CommonConstants.STATUS_DEL);
        dictInfoService.update(dictInfo, new LambdaQueryWrapperX<DictInfo>().eq(DictInfo::getId, dictCodeIdDto.getId()));
        DictDetail dictDetail = new DictDetail();
        dictDetail.setIsDelete(CommonConstants.STATUS_DEL);
        dictDetailService.update(dictDetail, new LambdaQueryWrapperX<DictDetail>().eq(DictDetail::getParentId, dictCodeIdDto.getId()));
    }

    public void deleteDictDetail(DictCodeIdDto dictCodeIdDto) {
        DictDetail dictDetail = new DictDetail();
        dictDetail.setIsDelete(CommonConstants.STATUS_DEL);
        dictDetailService.update(dictDetail, new LambdaQueryWrapperX<DictDetail>().eq(DictDetail::getId, dictCodeIdDto.getId()));
    }

    public void dictCreate(DictCreateDto dictCreateDto) {

        long count = dictDetailService.selectCount(new LambdaQueryWrapperX<DictDetail>()
                .eq(DictDetail::getIsDelete, CommonConstants.STATUS_NOT_DEL)
                .eq(DictDetail::getParentId, dictCreateDto.getParentId())
                .eq(DictDetail::getDictValue, dictCreateDto.getDictValue()));

        if (count > 0) {
            throw new BusinessException(ErrorCodeConstants.DICT_LABEL_EXISTS);
        }

        DictDetail dict = DictConvert.INSTANT.createDict(dictCreateDto);
        dict.setCreateBy(StpUtil.getLoginIdAsLong());
        dictDetailService.save(dict);
    }

    public List<DictDetailVo> queryDictByParentId(DictCodeIdDto dictCodeIdDto) {
        List<DictDetail> dictInfos = dictDetailService.selectList(new LambdaQueryWrapperX<DictDetail>()
                .eq(DictDetail::getIsDelete, CommonConstants.STATUS_NOT_DEL)
                .eq(DictDetail::getParentId, dictCodeIdDto.getId()));

        return DictConvert.INSTANT.converDetailList(dictInfos);
    }

    public List<DictInfoVo> dictInfoList(DictInfoListDto dictInfoListDto) {
        List<DictInfo> dictInfos = dictInfoService.selectList(new LambdaQueryWrapperX<DictInfo>().eqIfPresent(DictInfo::getDictType, dictInfoListDto.getDictType()));
        List<DictInfoVo> dictInfoVos = DictConvert.INSTANT.converList(dictInfos);
        String key = RedisConstants.DICT_KEY + dictInfoListDto.getDictType();
        redisOps.set(key, dictInfoVos, false);
        return dictInfoVos;
    }

}
