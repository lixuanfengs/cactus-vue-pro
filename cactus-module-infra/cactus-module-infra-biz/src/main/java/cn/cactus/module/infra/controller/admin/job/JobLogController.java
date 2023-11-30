package cn.cactus.module.infra.controller.admin.job;

import cn.cactus.framework.common.pojo.CommonResult;
import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.excel.core.util.ExcelUtils;
import cn.cactus.framework.operatelog.core.annotations.OperateLog;
import cn.cactus.module.infra.controller.admin.job.vo.log.JobLogExcelVO;
import cn.cactus.module.infra.controller.admin.job.vo.log.JobLogExportReqVO;
import cn.cactus.module.infra.controller.admin.job.vo.log.JobLogPageReqVO;
import cn.cactus.module.infra.controller.admin.job.vo.log.JobLogRespVO;
import cn.cactus.module.infra.convert.job.JobLogConvert;
import cn.cactus.module.infra.dal.dataobject.job.JobLogDO;
import cn.cactus.module.infra.service.job.JobLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static cn.cactus.framework.common.pojo.CommonResult.success;
import static cn.cactus.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

/**
 * Package: cn.cactus.module.infra.controller.admin.job
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 16:12
 * @Github https://github.com/lixuanfengs
 */
@Tag(name = "管理后台 - 定时任务日志")
@RestController
@RequestMapping("/infra/job-log")
@Validated
public class JobLogController {

    @Resource
    private JobLogService jobLogService;

    @GetMapping("/get")
    @Operation(summary = "获得定时任务日志")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:job:query')")
    public CommonResult<JobLogRespVO> getJobLog(@RequestParam("id") Long id) {
        JobLogDO jobLog = jobLogService.getJobLog(id);
        return success(JobLogConvert.INSTANCE.convert(jobLog));
    }

    @GetMapping("/list")
    @Operation(summary = "获得定时任务日志列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('infra:job:query')")
    public CommonResult<List<JobLogRespVO>> getJobLogList(@RequestParam("ids") Collection<Long> ids) {
        List<JobLogDO> list = jobLogService.getJobLogList(ids);
        return success(JobLogConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得定时任务日志分页")
    @PreAuthorize("@ss.hasPermission('infra:job:query')")
    public CommonResult<PageResult<JobLogRespVO>> getJobLogPage(@Valid JobLogPageReqVO pageVO) {
        PageResult<JobLogDO> pageResult = jobLogService.getJobLogPage(pageVO);
        return success(JobLogConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出定时任务日志 Excel")
    @PreAuthorize("@ss.hasPermission('infra:job:export')")
    @OperateLog(type = EXPORT)
    public void exportJobLogExcel(@Valid JobLogExportReqVO exportReqVO,
                                  HttpServletResponse response) throws IOException {
        List<JobLogDO> list = jobLogService.getJobLogList(exportReqVO);
        // 导出 Excel
        List<JobLogExcelVO> datas = JobLogConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "任务日志.xls", "数据", JobLogExcelVO.class, datas);
    }

}