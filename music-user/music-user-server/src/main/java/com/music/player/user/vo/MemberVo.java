package com.music.player.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ClassName : MemberVo<br>
 * Description : 会员视图对象<br>
 *
 * @author : sj
 * @date : 6/24/26
 */
@Setter
@Getter
@ToString
public class MemberVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String username;

    private String nickname;

    private String avatar;

    private String phone;

    private String gender;

    private LocalDate birthday;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long levelId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long groupId;

    private String tagIds;

    private Integer points;

    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
}
