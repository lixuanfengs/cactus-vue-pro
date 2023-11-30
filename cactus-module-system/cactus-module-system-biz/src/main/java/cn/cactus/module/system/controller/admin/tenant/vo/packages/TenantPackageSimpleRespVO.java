package cn.cactus.module.system.controller.admin.tenant.vo.packages;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.system.controller.admin.tenant.vo.packages
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:55
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 租户套餐精简 Response VO")
@Data
public class TenantPackageSimpleRespVO {

    @Schema(description = "套餐编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "套餐编号不能为空")
    private Long id;

    @Schema(description = "套餐名", requiredMode = Schema.RequiredMode.REQUIRED, example = "VIP")
    @NotNull(message = "套餐名不能为空")
    private String name;

}
