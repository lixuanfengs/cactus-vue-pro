package cn.cactus.module.infra.controller.admin.test.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Package: cn.cactus.module.infra.controller.admin.test.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:07
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "管理后台 - 字典类型创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TestDemoCreateReqVO extends TestDemoBaseVO {

}
