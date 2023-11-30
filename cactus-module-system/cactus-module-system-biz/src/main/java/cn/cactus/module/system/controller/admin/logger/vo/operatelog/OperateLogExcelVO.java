package cn.cactus.module.system.controller.admin.logger.vo.operatelog;

import cn.cactus.framework.excel.core.annotations.DictFormat;
import cn.cactus.framework.excel.core.convert.DictConvert;
import cn.cactus.module.system.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.system.controller.admin.logger.operatelog
 * Description:
 * 操作日志 Excel 导出响应 VO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:39
 * @Github https://github.com/lixuanfengs
 */
@Data
public class OperateLogExcelVO {

    @ExcelProperty("日志编号")
    private Long id;

    @ExcelProperty("操作模块")
    private String module;

    @ExcelProperty("操作名")
    private String name;

    @ExcelProperty(value = "操作类型", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.OPERATE_TYPE)
    private String type;

    @ExcelProperty("操作人")
    private String userNickname;

    @ExcelProperty(value = "操作结果") // 成功 or 失败
    private String successStr;

    @ExcelProperty("操作日志")
    private LocalDateTime startTime;

    @ExcelProperty("执行时长")
    private Integer duration;
}
