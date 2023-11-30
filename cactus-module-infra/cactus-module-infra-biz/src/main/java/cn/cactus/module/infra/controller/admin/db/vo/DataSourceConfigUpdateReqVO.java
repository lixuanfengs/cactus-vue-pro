package cn.cactus.module.infra.controller.admin.db.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.infra.controller.admin.db.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 16:04
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 数据源配置更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DataSourceConfigUpdateReqVO extends DataSourceConfigBaseVO {

    @Schema(description = "主键编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "主键编号不能为空")
    private Long id;

    @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @NotNull(message = "密码不能为空")
    private String password;

}

