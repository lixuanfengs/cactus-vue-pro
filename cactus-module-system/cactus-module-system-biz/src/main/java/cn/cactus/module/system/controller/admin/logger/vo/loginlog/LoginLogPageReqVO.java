package cn.cactus.module.system.controller.admin.logger.vo.loginlog;

import cn.cactus.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.cactus.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * Package: cn.cactus.module.system.controller.admin.logger.loginlog
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:37
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 登录日志分页列表 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class LoginLogPageReqVO extends PageParam {

    @Schema(description = "用户 IP，模拟匹配", example = "127.0.0.1")
    private String userIp;

    @Schema(description = "用户账号，模拟匹配", example = "芋道")
    private String username;

    @Schema(description = "操作状态", example = "true")
    private Boolean status;

    @Schema(description = "登录时间", example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
