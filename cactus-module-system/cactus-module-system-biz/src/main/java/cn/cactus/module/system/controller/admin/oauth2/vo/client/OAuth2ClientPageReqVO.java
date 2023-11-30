package cn.cactus.module.system.controller.admin.oauth2.vo.client;

import cn.cactus.framework.common.pojo.PageParam;
import cn.hutool.db.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Package: cn.cactus.module.system.controller.admin.oauth2.vo.client
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/20 11:03
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - OAuth2 客户端分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OAuth2ClientPageReqVO extends PageParam {

    @Schema(description = "应用名，模糊匹配", example = "土豆")
    private String name;

    @Schema(description = "状态，参见 CommonStatusEnum 枚举", example = "1")
    private Integer status;
}
