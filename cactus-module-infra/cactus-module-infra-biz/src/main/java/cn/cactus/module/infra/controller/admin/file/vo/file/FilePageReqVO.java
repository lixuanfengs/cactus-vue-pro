package cn.cactus.module.infra.controller.admin.file.vo.file;

import cn.cactus.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.cactus.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * Package: cn.cactus.module.infra.controller.admin.file.vo.file
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 16:06
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 文件分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FilePageReqVO extends PageParam {

    @Schema(description = "文件路径，模糊匹配", example = "yudao")
    private String path;

    @Schema(description = "文件类型，模糊匹配", example = "jpg")
    private String type;

    @Schema(description = "创建时间", example = "[2022-07-01 00:00:00, 2022-07-01 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
