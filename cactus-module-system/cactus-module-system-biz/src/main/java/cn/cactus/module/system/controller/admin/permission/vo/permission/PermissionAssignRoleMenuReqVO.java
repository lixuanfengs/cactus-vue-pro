package cn.cactus.module.system.controller.admin.permission.vo.permission;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Set;

/**
 * Package: cn.cactus.module.system.controller.admin.permission.vo.permission
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 11:02
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 赋予角色菜单 Request VO")
@Data
public class PermissionAssignRoleMenuReqVO {

    @Schema(description = "角色编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "角色编号不能为空")
    private Long roleId;

    @Schema(description = "菜单编号列表", example = "1,3,5")
    private Set<Long> menuIds = Collections.emptySet(); // 兜底

}

