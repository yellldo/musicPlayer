package com.music.player.chief.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class UpdateAuthorInfoDto implements Serializable {

    private Long authorId;

    private String authorName;

    private String idNumber;

    private String school;

    private String birthday;

    private String country;

    private String city;

    private String gender;

    private String profilePhoto;

    private String backgroundImage;
}
