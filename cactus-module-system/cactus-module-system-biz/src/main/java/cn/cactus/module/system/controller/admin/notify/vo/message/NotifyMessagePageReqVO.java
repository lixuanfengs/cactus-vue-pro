package cn.cactus.module.system.controller.admin.notify.vo.message;

import cn.cactus.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.cactus.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * Package: cn.cactus.module.system.controller.admin.notify.vo.message
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 10:55
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 站内信分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NotifyMessagePageReqVO extends PageParam {

    @Schema(description = "用户编号", example = "25025")
    private Long userId;

    @Schema(description = "用户类型", example = "1")
    private Integer userType;

    @Schema(description = "模板编码", example = "test_01")
    private String templateCode;

    @Schema(description = "模版类型", example = "2")
    private Integer templateType;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
