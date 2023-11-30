package cn.cactus.module.system.controller.admin.notice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.system.controller.admin.notice.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 10:53
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 岗位公告更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class NoticeUpdateReqVO extends NoticeBaseVO {

    @Schema(description = "岗位公告编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "岗位公告编号不能为空")
    private Long id;

}
