package com.music.player.chief.convert;

import com.music.player.chief.api.service.author.dto.ApprovalAuthorDto;
import com.music.player.chief.api.service.author.dto.AuthenticatedDto;
import com.music.player.chief.dto.UpdateAuthorInfoDto;
import com.music.player.chief.entity.AuthorApplyInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorApplyInfoConvert {

    AuthorApplyInfoConvert INSTANT = Mappers.getMapper(AuthorApplyInfoConvert.class);

    @Mappings({
            @Mapping(source = "authorName", target = "authorName"),
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "school", target = "school"),
            @Mapping(source = "birthday", target = "birthday"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "idNumber", target = "idNumber"),
            @Mapping(source = "country", target = "country"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "profilePhoto", target = "profilePhoto"),
            @Mapping(source = "backgroundImage", target = "backgroundImage"),
    })
    AuthorApplyInfo authenticated(AuthenticatedDto authenticatedDto);


    @Mappings({
            @Mapping(source = "authorApplyId", target = "authorApplyId"),
            @Mapping(source = "auditStatus", target = "auditStatus"),
            @Mapping(source = "auditRemark", target = "auditRemark")
    })
    AuthorApplyInfo approvalAuthor(ApprovalAuthorDto approvalAuthorDto);

    @Mappings({
            @Mapping(source = "authorName", target = "authorName"),
            @Mapping(source = "authorId", target = "authorId"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "idNumber", target = "idNumber"),
            @Mapping(source = "country", target = "country"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "profilePhoto", target = "profilePhoto"),
            @Mapping(source = "backgroundImage", target = "backgroundImage"),
    })
    AuthorApplyInfo updateAuthorInfo(UpdateAuthorInfoDto updateAuthorInfoDto);

}
