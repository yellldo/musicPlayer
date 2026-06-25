package com.music.player.content.biz;

import com.music.player.content.constant.GenreConstants;
import com.music.player.content.convert.GenreConvert;
import com.music.player.content.dto.GenreCreateDto;
import com.music.player.content.dto.GenrePageDto;
import com.music.player.content.dto.GenreUpdateDto;
import com.music.player.content.entity.Genre;
import com.music.player.content.enmus.ErrorCodeConstants;
import com.music.player.content.service.GenreService;
import com.music.player.content.vo.GenreVo;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName : GenreBiz<br>
 * Description : 音乐类型业务层<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Component
public class GenreBiz {

    @Autowired
    private GenreService genreService;

    public PageResult<GenreVo> page(GenrePageDto dto) {
        PageResult<Genre> pageResult = genreService.selectPage(dto, new LambdaQueryWrapperX<Genre>()
                .likeIfPresent(Genre::getName, dto.getName())
                .eqIfPresent(Genre::getStatus, dto.getStatus())
                .eq(Genre::getIsDelete, CommonConstants.STATUS_NOT_DEL));
        return GenreConvert.INSTANT.convertPage(pageResult);
    }

    public GenreVo detail(Long id) {
        Genre genre = genreService.getById(id);
        if (genre == null) {
            throw new BusinessException(ErrorCodeConstants.GENRE_NOT_FOUND);
        }
        return GenreConvert.INSTANT.toVo(genre);
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(GenreCreateDto dto) {
        Genre genre = GenreConvert.INSTANT.create(dto);
        if (genre.getStatus() == null) {
            genre.setStatus(GenreConstants.STATUS_ENABLED);
        }
        genreService.save(genre);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(GenreUpdateDto dto) {
        Genre origin = genreService.getById(dto.getId());
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.GENRE_NOT_FOUND);
        }
        Genre genre = GenreConvert.INSTANT.update(dto);
        genreService.updateById(genre);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Genre origin = genreService.getById(id);
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.GENRE_NOT_FOUND);
        }
        genreService.removeById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void toggleStatus(Long id) {
        Genre genre = genreService.getById(id);
        if (genre == null) {
            throw new BusinessException(ErrorCodeConstants.GENRE_NOT_FOUND);
        }
        String newStatus = GenreConstants.STATUS_ENABLED.equals(genre.getStatus())
                ? GenreConstants.STATUS_DISABLED
                : GenreConstants.STATUS_ENABLED;
        Genre update = new Genre();
        update.setId(id);
        update.setStatus(newStatus);
        genreService.updateById(update);
    }
}
