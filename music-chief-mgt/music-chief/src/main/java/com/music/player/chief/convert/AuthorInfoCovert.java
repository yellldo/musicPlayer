package com.music.player.chief.convert;

import com.music.player.chief.api.service.author.vo.FetchAuthorInfoVo;
import com.music.player.chief.entity.AuthorApplyInfo;
import com.music.player.chief.entity.AuthorInfo;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorInfoCovert {

    AuthorInfoCovert INSTANT = Mappers.getMapper(AuthorInfoCovert.class);

    @Mappings({
            @Mapping(source = "authorName", target = "authorName"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "country", target = "country"),
            @Mapping(source = "city", target = "city"),
    })
    AuthorInfo authorApplyInfo(AuthorApplyInfo authorApplyInfo);

    @Mappings({
            @Mapping(source = "authorName", target = "authorName"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "country", target = "country"),
            @Mapping(source = "city", target = "city")
    })
    FetchAuthorInfoVo fetchAuthorInfo(AuthorInfo authorInfo);
}
