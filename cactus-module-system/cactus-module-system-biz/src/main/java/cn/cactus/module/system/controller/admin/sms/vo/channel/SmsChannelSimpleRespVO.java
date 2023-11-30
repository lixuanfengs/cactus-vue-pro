package cn.cactus.module.system.controller.admin.sms.vo.channel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.system.controller.admin.sms.vo.channel
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 11:16
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 短信渠道精简 Response VO")
@Data
public class SmsChannelSimpleRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "编号不能为空")
    private Long id;

    @Schema(description = "短信签名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋道源码")
    @NotNull(message = "短信签名不能为空")
    private String signature;

    @Schema(description = "渠道编码，参见 SmsChannelEnum 枚举类", requiredMode = Schema.RequiredMode.REQUIRED, example = "YUN_PIAN")
    private String code;

}
