package cn.cactus.module.system.controller.admin.tenant.vo.packages;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.system.controller.admin.tenant.vo.packages
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:56
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 租户套餐更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TenantPackageUpdateReqVO extends TenantPackageBaseVO {

    @Schema(description = "套餐编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "套餐编号不能为空")
    private Long id;

}
