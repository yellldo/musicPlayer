package com.music.player.content.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : ArtistsDisassociateDto<br>
 * Description : ArtistsDisassociateDto<br>
 *
 * @author : sj
 * @date : 1/25/26
 */
@Setter
@Getter
@ToString
public class ArtistsDisassociateDto implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
}
