package cn.cactus.module.infra.controller.admin.demo.demo02.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.cactus.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * Package: cn.cactus.module.infra.controller.admin.demo.demo02.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/12/7 17:09
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 示例分类列表 Request VO")
@Data
public class Demo02CategoryListReqVO {

    @Schema(description = "名字", example = "芋艿")
    private String name;

    @Schema(description = "父级编号", example = "6080")
    private Long parentId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
