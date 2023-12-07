package cn.cactus.module.infra.controller.admin.demo.demo03.vo;

import cn.cactus.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.cactus.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * Package: cn.cactus.module.infra.controller.admin.demo.demo03.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/12/7 17:10
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 学生分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Demo03StudentPageReqVO extends PageParam {

    @Schema(description = "名字", example = "芋艿")
    private String name;

    @Schema(description = "性别")
    private Integer sex;

    @Schema(description = "简介", example = "随便")
    private String description;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
