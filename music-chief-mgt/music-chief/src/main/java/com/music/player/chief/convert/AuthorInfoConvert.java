package com.music.player.chief.convert;

import com.music.player.chief.api.service.author.vo.AuthorInfoVo;
import com.music.player.chief.api.service.author.vo.FetchAuthorInfoVo;
import com.music.player.chief.entity.AuthorApplyInfo;
import com.music.player.chief.entity.AuthorInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorInfoConvert {

    AuthorInfoConvert INSTANT = Mappers.getMapper(AuthorInfoConvert.class);

    @Mappings({
            @Mapping(source = "authorName", target = "authorName"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "country", target = "country"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "authorId", target = "authorId"),
            @Mapping(source = "idNumber", target = "idNumber"),
            @Mapping(source = "birthday", target = "birthday"),
            @Mapping(source = "school", target = "school"),
    })
    AuthorInfo authorApplyInfo(AuthorApplyInfo authorApplyInfo);

    @Mappings({
            @Mapping(source = "authorName", target = "authorName"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "country", target = "country"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "idNumber", target = "idNumber"),
            @Mapping(source = "birthday", target = "birthday"),
            @Mapping(source = "authorId", target = "authorId"),
            @Mapping(source = "school", target = "school"),
    })
    FetchAuthorInfoVo fetchAuthorInfo(AuthorInfo authorInfo);

    AuthorInfoVo authorInfoVo(AuthorInfo authorInfo);
}
