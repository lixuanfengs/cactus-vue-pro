package cn.cactus.module.infra.controller.admin.test.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.cactus.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * Package: cn.cactus.module.infra.controller.admin.test.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:07
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 字典类型 Excel 导出 Request VO，参数和 TestDemoPageReqVO 是一致的")
@Data
public class TestDemoExportReqVO {

    @Schema(description = "名字")
    private String name;

    @Schema(description = "状态")
    private Integer status;

    @Schema(description = "类型")
    private Integer type;

    @Schema(description = "分类")
    private Integer category;

    @Schema(description = "备注")
    private String remark;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "创建时间")
    private LocalDateTime[] createTime;

}

