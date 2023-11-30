package cn.cactus.module.infra.controller.admin.config.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.infra.controller.admin.config.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 16:02
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 参数配置创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ConfigUpdateReqVO extends ConfigBaseVO {

    @Schema(description = "参数配置序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "参数配置编号不能为空")
    private Long id;

}

