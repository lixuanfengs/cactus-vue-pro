package cn.cactus.module.system.controller.admin.user.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Package: cn.cactus.module.system.controller.admin.user.vo.user
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:20
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 用户导入 Response VO")
@Data
@Builder
public class UserImportRespVO {

    @Schema(description = "创建成功的用户名数组", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> createUsernames;

    @Schema(description = "更新成功的用户名数组", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> updateUsernames;

    @Schema(description = "导入失败的用户集合，key 为用户名，value 为失败原因", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failureUsernames;

}
