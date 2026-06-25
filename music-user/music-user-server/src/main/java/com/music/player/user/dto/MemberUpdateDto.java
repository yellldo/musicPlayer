package com.music.player.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * ClassName : MemberUpdateDto<br>
 * Description : 会员编辑参数<br>
 *
 * @author : sj
 * @date : 6/24/26
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class MemberUpdateDto implements Serializable {

    @NotNull(message = "会员ID不能为空")
    private Long id;

    private Long userId;

    private String username;

    private String nickname;

    private String avatar;

    private String phone;

    private String gender;

    private LocalDate birthday;

    private Long levelId;

    private Long groupId;

    private String tagIds;

    private Integer points;

    private String status;
}
