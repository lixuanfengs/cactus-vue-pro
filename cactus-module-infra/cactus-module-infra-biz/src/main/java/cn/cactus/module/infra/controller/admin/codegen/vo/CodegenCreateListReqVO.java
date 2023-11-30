package cn.cactus.module.infra.controller.admin.codegen.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Package: cn.cactus.module.infra.controller.admin.codegen.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:56
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 基于数据库的表结构，创建代码生成器的表和字段定义 Request VO")
@Data
public class CodegenCreateListReqVO {

    @Schema(description = "数据源配置的编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "数据源配置的编号不能为空")
    private Long dataSourceConfigId;

    @Schema(description = "表名数组", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2, 3]")
    @NotNull(message = "表名数组不能为空")
    private List<String> tableNames;

}