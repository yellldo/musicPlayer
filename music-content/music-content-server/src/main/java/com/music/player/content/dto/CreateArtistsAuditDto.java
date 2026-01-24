package com.music.player.content.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ClassName : CreateArtistsAuditDto<br>
 * Description : CreateArtistsAuditDto<br>
 *
 * @author : sj
 * @date : 1/13/26
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class CreateArtistsAuditDto implements Serializable {

    @NotNull(message = "缺失必要参数")
    private Long userId;

    private String submittedData;
}
