package com.music.player.framework.mybatis.mybatis.method;

import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById;
import lombok.NoArgsConstructor;

import java.util.function.Predicate;

/**
 * ClassName : UpdateAllById<br>
 * Description : 修改所有的字段<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@NoArgsConstructor
public class UpdateAllById extends AlwaysUpdateSomeColumnById {

    public UpdateAllById(Predicate<TableFieldInfo> predicate) {
        super("updateAllById", predicate);
    }
}
