package com.music.player.user.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * ClassName : UserInfoVo<br>
 * Description : UserInfoVo<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class UserInfoVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String nickName;

    private String userStatus;

    private String userType;

    private String phone;

    private String profile;

    private String avatar;

    private String gender;

    private String birthday;

    private int grade;

    private Integer followerCount;

    private Integer followingCount;

    private Integer membershipLevel;

    private String isAuthentication;

    private String city;

    private String province;

    private String isDelete;

    private String createTime;
}
