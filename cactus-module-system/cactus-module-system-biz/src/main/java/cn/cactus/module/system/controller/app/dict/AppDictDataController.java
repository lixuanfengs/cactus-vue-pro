package cn.cactus.module.system.controller.app.dict;

import cn.cactus.framework.common.pojo.CommonResult;
import cn.cactus.module.system.controller.app.dict.vo.AppDictDataRespVO;
import cn.cactus.module.system.convert.dict.DictDataConvert;
import cn.cactus.module.system.dal.dataobject.dict.DictDataDO;
import cn.cactus.module.system.service.dict.DictDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static cn.cactus.framework.common.pojo.CommonResult.success;

/**
 * Package: cn.cactus.module.system.controller.app.dict
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 15:40
 * @Github https://github.com/lixuanfengs
 */
@Tag(name = "用户 App - 字典数据")
@RestController
@RequestMapping("/system/dict-data")
@Validated
public class AppDictDataController {

    @Resource
    private DictDataService dictDataService;

    @GetMapping("/type")
    @Operation(summary = "根据字典类型查询字典数据信息")
    @Parameter(name = "type", description = "字典类型", required = true, example = "common_status")
    public CommonResult<List<AppDictDataRespVO>> getDictDataListByType(@RequestParam("type") String type) {
        List<DictDataDO> list = dictDataService.getEnabledDictDataListByType(type);
        return success(DictDataConvert.INSTANCE.convertList03(list));
    }

}