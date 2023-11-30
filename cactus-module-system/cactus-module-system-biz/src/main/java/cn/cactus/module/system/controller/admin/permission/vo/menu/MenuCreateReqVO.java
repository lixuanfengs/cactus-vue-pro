package cn.cactus.module.system.controller.admin.permission.vo.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Package: cn.cactus.module.system.controller.admin.permission.vo.menu
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 11:01
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 菜单创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuCreateReqVO extends MenuBaseVO {
}

