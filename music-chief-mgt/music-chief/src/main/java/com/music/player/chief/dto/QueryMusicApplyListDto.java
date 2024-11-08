package com.music.player.chief.dto;

import com.music.player.framework.common.base.QueryRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class QueryMusicApplyListDto extends QueryRequest implements Serializable {

    private String musicName;

    private String musicApplyStatus;

}
