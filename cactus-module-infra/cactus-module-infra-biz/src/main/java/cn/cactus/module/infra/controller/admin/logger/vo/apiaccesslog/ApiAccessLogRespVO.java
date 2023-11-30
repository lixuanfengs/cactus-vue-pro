package cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/15 11:07
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - API 访问日志 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ApiAccessLogRespVO extends ApiAccessLogBaseVO {

    @Schema(description = "日志主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
