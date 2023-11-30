package cn.cactus.module.system.controller.admin.dict.vo.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Package: cn.cactus.module.system.controller.admin.dict.vo.data
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/15 10:31
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 数据字典精简 Response VO")
@Data
public class DictDataSimpleRespVO {

    @Schema(description = "字典类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "gender")
    private String dictType;

    @Schema(description = "字典键值", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private String value;

    @Schema(description = "字典标签", requiredMode = Schema.RequiredMode.REQUIRED, example = "男")
    private String label;

    @Schema(description = "颜色类型，default、primary、success、info、warning、danger", example = "default")
    private String colorType;

    @Schema(description = "css 样式", example = "btn-visible")
    private String cssClass;

}
