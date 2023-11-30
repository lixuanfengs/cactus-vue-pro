package cn.cactus.module.infra.controller.admin.job.vo.log;

import cn.cactus.framework.excel.core.annotations.DictFormat;
import cn.cactus.framework.excel.core.convert.DictConvert;
import cn.cactus.module.infra.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.infra.controller.admin.job.vo.log
 * Description:
 * 定时任务 Excel VO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 16:15
 * @Github https://github.com/lixuanfengs
 */
@Data
public class JobLogExcelVO {

    @ExcelProperty("日志编号")
    private Long id;

    @ExcelProperty("任务编号")
    private Long jobId;

    @ExcelProperty("处理器的名字")
    private String handlerName;

    @ExcelProperty("处理器的参数")
    private String handlerParam;

    @ExcelProperty("第几次执行")
    private Integer executeIndex;

    @ExcelProperty("开始执行时间")
    private LocalDateTime beginTime;

    @ExcelProperty("结束执行时间")
    private LocalDateTime endTime;

    @ExcelProperty("执行时长")
    private Integer duration;

    @ExcelProperty(value = "任务状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.JOB_STATUS)
    private Integer status;

    @ExcelProperty("结果数据")
    private String result;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}

