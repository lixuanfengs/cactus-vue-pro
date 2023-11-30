package cn.cactus.module.system.controller.admin.permission.vo.role;

import cn.cactus.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.cactus.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * Package: cn.cactus.module.system.controller.admin.permission.vo.role
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 11:05
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 角色分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class RolePageReqVO extends PageParam {

    @Schema(description = "角色名称，模糊匹配", example = "芋道")
    private String name;

    @Schema(description = "角色标识，模糊匹配", example = "yudao")
    private String code;

    @Schema(description = "展示状态，参见 CommonStatusEnum 枚举类", example = "1")
    private Integer status;

    @Schema(description = "创建时间", example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}

