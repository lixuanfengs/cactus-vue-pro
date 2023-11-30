package cn.cactus.module.system.controller.admin.mail.vo.account;

import cn.cactus.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Package: cn.cactus.module.system.controller.admin.mail.vo.account
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 10:15
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 邮箱账号分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MailAccountPageReqVO extends PageParam {

    @Schema(description = "邮箱", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudaoyuanma@123.com")
    private String mail;

    @Schema(description = "用户名" , requiredMode = Schema.RequiredMode.REQUIRED , example = "yudao")
    private String username;

}

