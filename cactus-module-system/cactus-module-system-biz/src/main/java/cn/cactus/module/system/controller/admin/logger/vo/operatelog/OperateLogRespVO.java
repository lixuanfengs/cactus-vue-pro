package cn.cactus.module.system.controller.admin.logger.vo.operatelog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Package: cn.cactus.module.system.controller.admin.logger.operatelog
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:41
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 操作日志 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OperateLogRespVO extends OperateLogBaseVO {

    @Schema(description = "日志编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "用户昵称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    private String userNickname;

}
