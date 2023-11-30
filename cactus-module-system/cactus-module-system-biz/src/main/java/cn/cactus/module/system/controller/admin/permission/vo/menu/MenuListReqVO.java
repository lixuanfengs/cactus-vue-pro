package cn.cactus.module.system.controller.admin.permission.vo.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Package: cn.cactus.module.system.controller.admin.permission.vo.menu
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 11:01
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 菜单列表 Request VO")
@Data
public class MenuListReqVO {

    @Schema(description = "菜单名称，模糊匹配", example = "芋道")
    private String name;

    @Schema(description = "展示状态，参见 CommonStatusEnum 枚举类", example = "1")
    private Integer status;

}
