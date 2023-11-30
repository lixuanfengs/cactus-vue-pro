package cn.cactus.module.infra.controller.admin.codegen.vo.table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Package: cn.cactus.module.infra.controller.admin.codegen.vo.table
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:59
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 数据库的表定义 Response VO")
@Data
public class DatabaseTableRespVO {

    @Schema(description = "表名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "yuanma")
    private String name;

    @Schema(description = "表描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋道源码")
    private String comment;

}
