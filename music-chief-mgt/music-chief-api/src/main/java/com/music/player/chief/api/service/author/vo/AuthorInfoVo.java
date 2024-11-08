package com.music.player.chief.api.service.author.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class AuthorInfoVo implements Serializable {

    private String authorName;

    private String gender;

    private String country;

    private String city;

    private String school;

    private String idNumber;

    private String birthday;

    private String profilePhoto;

    private String authorStatus;
}
