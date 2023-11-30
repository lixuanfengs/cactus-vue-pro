package cn.cactus.module.system.controller.admin.mail.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Package: cn.cactus.module.system.controller.admin.mail.vo.template
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 10:20
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 邮件模版创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MailTemplateCreateReqVO extends MailTemplateBaseVO {

}
