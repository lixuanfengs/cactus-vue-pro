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
 * @Date 2023/11/27 16:03
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 数据源配置创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DataSourceConfigCreateReqVO extends DataSourceConfigBaseVO {

    @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @NotNull(message = "密码不能为空")
    private String password;

}
