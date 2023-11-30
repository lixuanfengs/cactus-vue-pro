package cn.cactus.module.system.controller.admin.tenant.vo.tenant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Package: cn.cactus.module.system.controller.admin.tenant.vo.tenant
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 17:18
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 租户精简 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TenantSimpleRespVO extends TenantBaseVO {

    @Schema(description = "租户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "租户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋道")
    private String name;

}
