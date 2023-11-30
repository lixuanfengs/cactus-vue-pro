package cn.cactus.module.system.controller.admin.errorcode.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.system.controller.admin.errorcode.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 10:09
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 错误码更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErrorCodeUpdateReqVO extends ErrorCodeBaseVO {

    @Schema(description = "错误码编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "错误码编号不能为空")
    private Long id;

}
