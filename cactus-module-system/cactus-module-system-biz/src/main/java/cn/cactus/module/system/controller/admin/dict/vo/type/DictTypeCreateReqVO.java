package cn.cactus.module.system.controller.admin.dict.vo.type;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Package: cn.cactus.module.system.controller.admin.dict.vo.type
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/15 10:32
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 字典类型创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class DictTypeCreateReqVO extends DictTypeBaseVO {

    @Schema(description = "字典类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "sys_common_sex")
    @NotNull(message = "字典类型不能为空")
    @Size(max = 100, message = "字典类型类型长度不能超过100个字符")
    private String type;

}
