package cn.cactus.module.system.controller.admin.mail.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Package: cn.cactus.module.system.controller.admin.mail.vo.template
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 10:21
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 邮件模版的精简 Response VO")
@Data
public class MailTemplateSimpleRespVO {

    @Schema(description = "模版编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "模版名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "哒哒哒")
    private String name;

}

