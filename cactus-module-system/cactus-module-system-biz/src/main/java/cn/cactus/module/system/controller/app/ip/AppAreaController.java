package cn.cactus.module.system.controller.app.ip;

import cn.cactus.framework.common.pojo.CommonResult;
import cn.cactus.framework.ip.core.Area;
import cn.cactus.framework.ip.core.utils.AreaUtils;
import cn.cactus.module.system.controller.app.ip.vo.AppAreaNodeRespVO;
import cn.cactus.module.system.convert.ip.AreaConvert;
import cn.hutool.core.lang.Assert;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.cactus.framework.common.pojo.CommonResult.success;

/**
 * Package: cn.cactus.module.system.controller.app.ip
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 15:40
 * @Github https://github.com/lixuanfengs
 */
@Tag(name = "用户 App - 地区")
@RestController
@RequestMapping("/system/area")
@Validated
public class AppAreaController {

    @GetMapping("/tree")
    @Operation(summary = "获得地区树")
    public CommonResult<List<AppAreaNodeRespVO>> getAreaTree() {
        Area area = AreaUtils.getArea(Area.ID_CHINA);
        Assert.notNull(area, "获取不到中国");
        return success(AreaConvert.INSTANCE.convertList3(area.getChildren()));
    }

}