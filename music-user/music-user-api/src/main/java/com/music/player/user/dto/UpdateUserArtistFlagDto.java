package com.music.player.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : UpdateUserArtistFlagDto<br>
 * Description : UpdateUserArtistFlagDto<br>
 *
 * @author : sj
 * @date : 1/10/26
 */
@Setter
@Getter
@ToString
public class UpdateUserArtistFlagDto implements Serializable {

    private Long userId;

    private String isArtist;
}
