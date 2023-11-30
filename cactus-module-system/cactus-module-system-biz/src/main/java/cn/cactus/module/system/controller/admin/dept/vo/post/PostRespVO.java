package cn.cactus.module.system.controller.admin.dept.vo.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.system.controller.admin.dept.vo.post
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 10:03
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 岗位信息 Response VO")
@Data
public class PostRespVO {

    @Schema(description = "岗位序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "时间戳格式")
    private LocalDateTime createTime;

}
