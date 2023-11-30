package cn.cactus.module.system.controller.admin.notice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Package: cn.cactus.module.system.controller.admin.notice.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 10:52
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 通知公告创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class NoticeCreateReqVO extends NoticeBaseVO {
}

