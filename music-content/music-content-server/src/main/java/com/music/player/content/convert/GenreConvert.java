package com.music.player.content.convert;

import com.music.player.content.dto.GenreCreateDto;
import com.music.player.content.dto.GenreUpdateDto;
import com.music.player.content.entity.Genre;
import com.music.player.content.vo.GenreVo;
import com.music.player.framework.common.base.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : GenreConvert<br>
 * Description : 音乐类型对象转换<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Mapper
public interface GenreConvert {

    GenreConvert INSTANT = Mappers.getMapper(GenreConvert.class);

    Genre create(GenreCreateDto dto);

    Genre update(GenreUpdateDto dto);

    PageResult<GenreVo> convertPage(PageResult<Genre> pageResult);

    GenreVo toVo(Genre entity);
}
