package com.music.player.framework.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.id.utils.IdUtils;
import com.music.player.framework.mybatis.constants.EntityConstant;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * ClassName : MetaDataHandler<br>
 * Description : MetaDataHandler<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Setter
@Getter
@Slf4j
public class MetaDataHandler implements MetaObjectHandler {

    @Autowired
    private IdUtils idUtils;

    @Override
    public void insertFill(MetaObject metaObject) {
        insertCommonColumn(metaObject);
        updateCommonColumn(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        updateCommonColumn(metaObject);
    }

    public void insertCommonColumn(MetaObject metaObject) {
        extractLocalDateTime(metaObject, EntityConstant.CREATED_TIME_FIELD);
        extractIsDelete(metaObject, EntityConstant.IS_DELETE_FIELD);
    }

    public void updateCommonColumn(MetaObject metaObject) {
        extractLocalDateTime(metaObject, EntityConstant.UPDATED_TIME_FIELD);
    }

    /**
     * 时间字段填充
     *
     * @param metaObject 元对象
     * @param field      字段属性
     */
    private void extractLocalDateTime(MetaObject metaObject, String field) {
        boolean hasGetter = metaObject.hasGetter(field);
        if (hasGetter) {
            Object dateVal = this.getFieldValByName(field, metaObject);
            if (ObjectUtils.isEmpty(dateVal)) {
                this.setFieldValByName(field, LocalDateTime.now(), metaObject);
            }
        }
    }

    private void extractIsDelete(MetaObject metaObject, String field) {
        boolean hasGetter = metaObject.hasGetter(field);
        if (hasGetter) {
            Object dateVal = this.getFieldValByName(field, metaObject);
            if (ObjectUtils.isEmpty(dateVal)) {
                this.setFieldValByName(field, CommonConstants.STATUS_NOT_DEL, metaObject);
            }
        }
    }

}
