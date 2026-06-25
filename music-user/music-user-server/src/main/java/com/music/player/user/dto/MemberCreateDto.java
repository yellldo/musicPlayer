package com.music.player.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * ClassName : MemberCreateDto<br>
 * Description : 会员新增参数<br>
 *
 * @author : sj
 * @date : 6/24/26
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class MemberCreateDto implements Serializable {

    @NotBlank(message = "用户名不能为空")
    private String username;

    private Long userId;

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
