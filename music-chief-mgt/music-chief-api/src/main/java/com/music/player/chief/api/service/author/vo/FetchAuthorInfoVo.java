package com.music.player.chief.api.service.author.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class FetchAuthorInfoVo {

    private String authorName;

    private String country;

    private String city;

    private String gender;

}
