package com.music.player.content.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : ArtistsVo<br>
 * Description : ArtistsVo<br>
 *
 * @author : sj
 * @date : 1/10/26
 */
@Setter
@Getter
@ToString
public class ArtistsVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long artId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String userName;

    private String artName;

    private String alias;

    private Integer musicSize;

    private Integer albumSize;

    private String description;

}
