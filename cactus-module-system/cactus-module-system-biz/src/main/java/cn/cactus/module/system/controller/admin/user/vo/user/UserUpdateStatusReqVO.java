package cn.cactus.module.system.controller.admin.user.vo.user;

import cn.cactus.framework.common.enums.CommonStatusEnum;
import cn.cactus.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.system.controller.admin.user.vo.user
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:26
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 用户更新状态 Request VO")
@Data
public class UserUpdateStatusReqVO {

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "角色编号不能为空")
    private Long id;

    @Schema(description = "状态，见 CommonStatusEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    @InEnum(value = CommonStatusEnum.class, message = "修改状态必须是 {value}")
    private Integer status;

}
