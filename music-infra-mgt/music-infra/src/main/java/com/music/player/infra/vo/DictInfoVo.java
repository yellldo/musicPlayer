package com.music.player.infra.vo;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * ClassName : DictInfoVo<br>
 * Description : DictInfoVo<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@ToString
@Service
@Getter
@ApiModel("字典结果实体")
public class DictInfoVo implements Serializable {


    private Integer id;

    private Integer parentId;

    private String dictType;

    private String dictKey;

    private String dictValue;

    private String dictStatus;

    private String dictRemark;
}
