package cn.cactus.module.infra.controller.admin.logger;

import cn.cactus.framework.common.pojo.CommonResult;
import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.excel.core.util.ExcelUtils;
import cn.cactus.framework.operatelog.core.annotations.OperateLog;
import cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExcelVO;
import cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExportReqVO;
import cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogPageReqVO;
import cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogRespVO;
import cn.cactus.module.infra.convert.logger.ApiAccessLogConvert;
import cn.cactus.module.infra.dal.dataobject.logger.ApiAccessLogDO;
import cn.cactus.module.infra.service.logger.ApiAccessLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static cn.cactus.framework.common.pojo.CommonResult.success;
import static cn.cactus.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

/**
 * Package: cn.cactus.module.infra.controller.admin.logger
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 17:45
 * @Github https://github.com/lixuanfengs
 */
@Tag(name = "管理后台 - API 访问日志")
@RestController
@RequestMapping("/infra/api-access-log")
@Validated
public class ApiAccessLogController {

    @Resource
    private ApiAccessLogService apiAccessLogService;

    @GetMapping("/page")
    @Operation(summary = "获得API 访问日志分页")
    @PreAuthorize("@ss.hasPermission('infra:api-access-log:query')")
    public CommonResult<PageResult<ApiAccessLogRespVO>> getApiAccessLogPage(@Valid ApiAccessLogPageReqVO pageVO) {
        PageResult<ApiAccessLogDO> pageResult = apiAccessLogService.getApiAccessLogPage(pageVO);
        return success(ApiAccessLogConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出API 访问日志 Excel")
    @PreAuthorize("@ss.hasPermission('infra:api-access-log:export')")
    @OperateLog(type = EXPORT)
    public void exportApiAccessLogExcel(@Valid ApiAccessLogExportReqVO exportReqVO,
                                        HttpServletResponse response) throws IOException {
        List<ApiAccessLogDO> list = apiAccessLogService.getApiAccessLogList(exportReqVO);
        // 导出 Excel
        List<ApiAccessLogExcelVO> datas = ApiAccessLogConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "API 访问日志.xls", "数据", ApiAccessLogExcelVO.class, datas);
    }

}