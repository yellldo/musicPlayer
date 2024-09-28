package com.music.player.infra.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : InfraFileConfig<br>
 * Description : InfraFileConfig<br>
 *
 * @author : sj
 * @date : 2024/9/25
 */
@Setter
@Getter
@ToString
@TableName("infra_file_config")
public class InfraFileConfig {

    private Long id;
}
