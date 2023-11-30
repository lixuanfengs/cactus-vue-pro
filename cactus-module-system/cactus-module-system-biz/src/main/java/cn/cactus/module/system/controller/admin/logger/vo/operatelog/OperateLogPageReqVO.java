package cn.cactus.module.system.controller.admin.logger.vo.operatelog;

import cn.cactus.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.cactus.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * Package: cn.cactus.module.system.controller.admin.logger.operatelog
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:40
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 操作日志分页列表 Request VO")
@Data
public class OperateLogPageReqVO extends PageParam {

    @Schema(description = "操作模块，模拟匹配", example = "订单")
    private String module;

    @Schema(description = "用户昵称，模拟匹配", example = "芋道")
    private String userNickname;

    @Schema(description = "操作分类，参见 OperateLogTypeEnum 枚举类", example = "1")
    private Integer type;

    @Schema(description = "操作状态", example = "true")
    private Boolean success;

    @Schema(description = "开始时间", example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] startTime;

}
