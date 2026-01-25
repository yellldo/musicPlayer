package com.music.player.user.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.music.player.framework.web.serializer.FlexibleListDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName : QueryUserDto<br>
 * Description : QueryUserDto<br>
 *
 * @author : sj
 * @date : 1/13/26
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class QueryUserDto implements Serializable {

    @JsonDeserialize(using = FlexibleListDeserializer.class)
    private List<Long> userIdList;
}
