package cn.cactus.module.system.controller.admin.dict.vo.type;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.system.controller.admin.dict.vo.type
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/15 10:36
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 字典类型更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class DictTypeUpdateReqVO extends DictTypeBaseVO {

    @Schema(description = "字典类型编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "字典类型编号不能为空")
    private Long id;

}
