package cn.cactus.module.system.controller.admin.notice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.system.controller.admin.notice.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 10:53
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 通知公告信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class NoticeRespVO extends NoticeBaseVO {

    @Schema(description = "通知公告序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "时间戳格式")
    private LocalDateTime createTime;

}

