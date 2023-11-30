package cn.cactus.module.infra.controller.admin.file.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Package: cn.cactus.module.infra.controller.admin.file.vo.config
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 16:07
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 文件配置更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FileConfigUpdateReqVO extends FileConfigBaseVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "编号不能为空")
    private Long id;

    @Schema(description = "存储配置,配置是动态参数，所以使用 Map 接收", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "存储配置不能为空")
    private Map<String, Object> config;

}
