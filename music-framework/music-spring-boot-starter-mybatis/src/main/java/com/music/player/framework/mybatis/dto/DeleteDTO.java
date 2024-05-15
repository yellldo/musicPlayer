package com.music.player.framework.mybatis.dto;

import lombok.Data;

import java.util.List;

/**
 * ClassName : DeleteDTO<br>
 * Description : 删除入参<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Data
public class DeleteDTO<ID> {

    private List<ID> ids;
}
