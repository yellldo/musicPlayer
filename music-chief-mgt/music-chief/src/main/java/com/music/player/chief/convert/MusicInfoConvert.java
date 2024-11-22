package com.music.player.chief.convert;

import com.music.player.chief.dto.PublishMusicDto;
import com.music.player.chief.entity.MusicApplyInfo;
import com.music.player.chief.entity.MusicInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author shenjia
 */
@Mapper
public interface MusicInfoConvert {

    MusicInfoConvert INSTANT = Mappers.getMapper(MusicInfoConvert.class);

    @Mappings({
            @Mapping(source = "musicName", target = "musicName"),
            @Mapping(source = "musicCover", target = "musicCover"),
            @Mapping(source = "authorId", target = "authorId"),
            @Mapping(source = "collectCount", target = "collectCount"),
            @Mapping(source = "duration", target = "duration"),
            @Mapping(source = "musicUrl", target = "musicUrl"),
    })
    MusicApplyInfo publishMusic(PublishMusicDto publishMusicDto);


    MusicInfo musicApplyInfo(MusicApplyInfo musicApplyInfo);
}
