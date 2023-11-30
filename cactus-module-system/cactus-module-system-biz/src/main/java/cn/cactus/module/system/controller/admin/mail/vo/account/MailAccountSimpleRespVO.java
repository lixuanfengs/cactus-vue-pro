package cn.cactus.module.system.controller.admin.mail.vo.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Package: cn.cactus.module.system.controller.admin.mail.vo.account
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 10:16
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 邮箱账号的精简 Response VO")
@Data
public class MailAccountSimpleRespVO {

    @Schema(description = "邮箱编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "邮箱", requiredMode = Schema.RequiredMode.REQUIRED, example = "768541388@qq.com")
    private String mail;

}
