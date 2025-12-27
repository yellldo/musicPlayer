package com.music.player.system.mapper;

import com.music.player.framework.mybatis.core.mapper.CommonMapper;
import com.music.player.system.dto.DictCodeDto;
import com.music.player.system.entity.DictDetail;
import com.music.player.system.vo.DictDetailVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName : DictDetailMapper<br>
 * Description : DictDetailMapper<br>
 *
 * @author : sj
 * @date : 10/19/25
 */
public interface DictDetailMapper extends CommonMapper<DictDetail> {

    @Select(" select " +
            " dd.dict_label , " +
            " dd.dict_value from " +
            " dict_info di inner join dict_detail dd on " +
            " di.id = dd.parent_id where " +
            " di.dict_code = #{dictCodeDto.dictCode} " +
            " and dd.is_delete = '0' " +
            " and di.is_delete = '0' ")
    List<DictDetailVo> queryDictByDictCode(@Param("dictCodeDto") DictCodeDto dictCodeDto);
}
