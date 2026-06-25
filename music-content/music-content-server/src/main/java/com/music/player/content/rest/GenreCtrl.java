package com.music.player.content.rest;

import com.music.player.content.biz.GenreBiz;
import com.music.player.content.dto.GenreCreateDto;
import com.music.player.content.dto.GenrePageDto;
import com.music.player.content.dto.GenreUpdateDto;
import com.music.player.framework.common.base.R;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : GenreCtrl<br>
 * Description : 音乐类型管理<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@RestController
@RequestMapping("/content/genres")
public class GenreCtrl {

    @Autowired
    private GenreBiz genreBiz;

    @GetMapping
    public R page(GenrePageDto dto) {
        return R.ok(genreBiz.page(dto));
    }

    @GetMapping("/{id}")
    public R detail(@PathVariable Long id) {
        return R.ok(genreBiz.detail(id));
    }

    @PostMapping
    public R create(@Valid @RequestBody GenreCreateDto dto) {
        genreBiz.create(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R update(@PathVariable Long id, @Valid @RequestBody GenreUpdateDto dto) {
        dto.setId(id);
        genreBiz.update(dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        genreBiz.delete(id);
        return R.ok();
    }

    @PutMapping("/{id}/status")
    public R toggleStatus(@PathVariable Long id) {
        genreBiz.toggleStatus(id);
        return R.ok();
    }
}
