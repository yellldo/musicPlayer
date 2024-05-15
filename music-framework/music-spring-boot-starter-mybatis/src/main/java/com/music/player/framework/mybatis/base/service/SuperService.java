package com.music.player.framework.mybatis.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.music.player.framework.common.support.ExceptionAssert;
import com.music.player.framework.common.support.code.ResultErrorCode;
import com.music.player.framework.mybatis.base.mapper.SuperMapper;

import java.util.List;

/**
 * ClassName : SuperService<br>
 * Description : SuperService<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public interface SuperService<T> extends IService<T> {

    /**
     * 批量保存
     *
     * @param entityList 实体对象
     * @return boolean
     */
    default boolean saveBatchSomeColumn(List<T> entityList) {
        int size = 5000;
        if (entityList.isEmpty()) {
            return true;
        } else if (entityList.size() > size) {
            ExceptionAssert.failure(ResultErrorCode.TOO_MUCH_DATA_ERROR);
        } else {
            return SqlHelper.retBool(((SuperMapper<T>) this.getBaseMapper()).insertBatchSomeColumn(entityList));
        }
        return false;
    }
}
