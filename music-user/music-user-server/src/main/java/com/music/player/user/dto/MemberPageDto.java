package com.music.player.user.dto;

import com.music.player.framework.common.base.QueryRequestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : MemberPageDto<br>
 * Description : 会员分页查询参数<br>
 *
 * @author : sj
 * @date : 6/24/26
 */
@Setter
@Getter
@ToString
public class MemberPageDto extends QueryRequestParam {

    private String username;

    private String nickname;

    private Long levelId;

    private Long groupId;

    private String status;
}
