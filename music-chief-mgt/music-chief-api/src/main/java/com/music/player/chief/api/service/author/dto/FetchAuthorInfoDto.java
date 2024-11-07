package com.music.player.chief.api.service.author.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class FetchAuthorInfoDto implements Serializable {

    private Long id;
}
