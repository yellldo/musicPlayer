package com.music.player.framework.common.base;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : QueryRequest<br>
 * Description : QueryRequest<br>
 *
 * @author : sj
 * @date : 8/31/25
 */
@Setter
@Getter
@ToString
@Schema(description = "分页参数")
public class QueryRequest implements Serializable {


    /**
     * 每页条数 - 不分页
     * <p>
     * 例如说，导出接口，可以设置 {@link #pageSize} 为 -1 不分页，查询所有数据。
     */
    public static final Integer PAGE_SIZE_NONE = -1;

    /**
     * 当前页面数据量
     */
    @Schema(description = "每页条数，最大值为 100", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "每页条数不能为空")
    @Min(value = 1, message = "每页条数最小值为 1")
    @Max(value = 100, message = "每页条数最大值为 100")
    private int pageSize = 10;

    /**
     * 当前页码
     */
    @Schema(description = "页码，从 1 开始", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码最小值为 1")
    private int pageNum = 1;
}
