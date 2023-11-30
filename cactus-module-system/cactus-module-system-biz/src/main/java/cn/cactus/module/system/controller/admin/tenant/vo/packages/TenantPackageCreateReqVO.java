package cn.cactus.module.system.controller.admin.tenant.vo.packages;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Package: cn.cactus.module.system.controller.admin.tenant.vo.packages
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:54
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 租户套餐创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TenantPackageCreateReqVO extends TenantPackageBaseVO {

}
