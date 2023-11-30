package cn.cactus.module.system.controller.admin.permission.vo.role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: cn.cactus.module.system.controller.admin.permission.vo.role
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 11:06
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 角色精简信息 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleSimpleRespVO {

    @Schema(description = "角色编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "角色名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋道")
    private String name;

}
