package cn.cactus.module.system.controller.admin.socail.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.system.controller.admin.socail.vo.user
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 11:29
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 社交用户 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SocialUserRespVO extends SocialUserBaseVO {

    @Schema(description = "主键(自增策略)", requiredMode = Schema.RequiredMode.REQUIRED, example = "14569")
    private Long id;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "更新时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

}