package com.music.player.user.dto;

import com.music.player.framework.common.base.QueryRequestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberTagPageDto extends QueryRequestParam {

    private String name;

    private String status;
}
