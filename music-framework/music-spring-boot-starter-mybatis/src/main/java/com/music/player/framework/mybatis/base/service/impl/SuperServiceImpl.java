package com.music.player.framework.mybatis.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.framework.mybatis.base.mapper.SuperMapper;
import com.music.player.framework.mybatis.base.service.SuperService;

/**
 * ClassName : SuperServiceImpl<br>
 * Description : SuperServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
public class SuperServiceImpl<M extends SuperMapper<T>, T> extends ServiceImpl<M, T> implements SuperService<T> {

    public SuperServiceImpl() {
    }

    @Override
    public boolean save(T model) {
        return super.save(model);
    }

    @Override
    public boolean updateById(T model) {
        return super.updateById(model);
    }
}
