package cn.cactus.module.infra.controller.admin.codegen.vo;

import cn.cactus.module.infra.controller.admin.codegen.vo.column.CodegenColumnRespVO;
import cn.cactus.module.infra.controller.admin.codegen.vo.table.CodegenTableRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Package: cn.cactus.module.infra.controller.admin.codegen.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:59
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 代码生成表和字段的明细 Response VO")
@Data
public class CodegenDetailRespVO {

    @Schema(description = "表定义")
    private CodegenTableRespVO table;

    @Schema(description = "字段定义")
    private List<CodegenColumnRespVO> columns;

}
