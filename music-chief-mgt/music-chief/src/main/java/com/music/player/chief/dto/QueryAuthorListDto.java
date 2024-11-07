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
public class QueryAuthorListDto extends QueryRequest implements Serializable {

    private String authName;

}
