package cn.cactus.module.infra.controller.admin.test.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.infra.controller.admin.test.vo
 * Description:
 * 字典类型 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:06
 * @Github https://github.com/lixuanfengs
 */
@Data
public class TestDemoBaseVO {

    @Schema(description = "名字", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "名字不能为空")
    private String name;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "类型", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "类型不能为空")
    private Integer type;

    @Schema(description = "分类", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "分类不能为空")
    private Integer category;

    @Schema(description = "备注")
    private String remark;

}
