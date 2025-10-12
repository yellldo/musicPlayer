package com.music.player.user.dto;

import com.music.player.framework.common.base.QueryRequestParam;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : UserInfoPageDto<br>
 * Description : UserInfoPageDto<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class UserInfoPageDto extends QueryRequestParam {

    private String nickName;

    private String userStatus;

    private String userType;
}
