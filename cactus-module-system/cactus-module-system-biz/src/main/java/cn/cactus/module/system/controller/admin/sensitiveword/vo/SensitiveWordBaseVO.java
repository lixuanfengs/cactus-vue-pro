package cn.cactus.module.system.controller.admin.sensitiveword.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Package: cn.cactus.module.system.controller.admin.sensitiveword.vo
 * Description:
 * 敏感词 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 11:10
 * @Github https://github.com/lixuanfengs
 */
@Data
public class SensitiveWordBaseVO {

    @Schema(description = "敏感词", requiredMode = Schema.RequiredMode.REQUIRED, example = "敏感词")
    @NotNull(message = "敏感词不能为空")
    private String name;

    @Schema(description = "标签", requiredMode = Schema.RequiredMode.REQUIRED, example = "短信,评论")
    @NotNull(message = "标签不能为空")
    private List<String> tags;

    @Schema(description = "状态，参见 CommonStatusEnum 枚举类", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "描述", example = "污言秽语")
    private String description;

}
