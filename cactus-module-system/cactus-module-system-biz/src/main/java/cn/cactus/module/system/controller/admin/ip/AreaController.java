package cn.cactus.module.system.controller.admin.ip;

import cn.cactus.framework.common.pojo.CommonResult;
import cn.cactus.framework.ip.core.Area;
import cn.cactus.framework.ip.core.utils.AreaUtils;
import cn.cactus.framework.ip.core.utils.IPUtils;
import cn.cactus.module.system.controller.admin.ip.vo.AreaNodeRespVO;
import cn.cactus.module.system.convert.ip.AreaConvert;
import cn.hutool.core.lang.Assert;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.cactus.framework.common.pojo.CommonResult.success;

/**
 * Package: cn.cactus.module.system.controller.admin.ip
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 10:10
 * @Github https://github.com/lixuanfengs
 */
@Tag(name = "管理后台 - 地区")
@RestController
@RequestMapping("/system/area")
@Validated
public class AreaController {

    @GetMapping("/tree")
    @Operation(summary = "获得地区树")
    public CommonResult<List<AreaNodeRespVO>> getAreaTree() {
        Area area = AreaUtils.getArea(Area.ID_CHINA);
        Assert.notNull(area, "获取不到中国");
        return success(AreaConvert.INSTANCE.convertList(area.getChildren()));
    }

    @GetMapping("/get-by-ip")
    @Operation(summary = "获得 IP 对应的地区名")
    @Parameter(name = "ip", description = "IP", required = true)
    public CommonResult<String> getAreaByIp(@RequestParam("ip") String ip) {
        // 获得城市
        Area area = IPUtils.getArea(ip);
        if (area == null) {
            return success("未知");
        }
        // 格式化返回
        return success(AreaUtils.format(area.getId()));
    }

}
