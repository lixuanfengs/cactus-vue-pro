package cn.cactus.module.infra.controller.admin.codegen.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Package: cn.cactus.module.infra.controller.admin.codegen.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:59
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 代码生成预览 Response VO，注意，每个文件都是一个该对象")
@Data
public class CodegenPreviewRespVO {

    @Schema(description = "文件路径", requiredMode = Schema.RequiredMode.REQUIRED, example = "java/cn/cactus/adminserver/modules/system/controller/test/SysTestDemoController.java")
    private String filePath;

    @Schema(description = "代码", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hello World")
    private String code;

}
