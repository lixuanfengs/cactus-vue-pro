package cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog;

import cn.cactus.framework.excel.core.annotations.DictFormat;
import cn.cactus.framework.excel.core.convert.DictConvert;
import cn.cactus.module.system.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.infra.controller.admin.logger.vo.apiaccesslog
 * Description:
 * API 访问日志 Excel VO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 17:55
 * @Github https://github.com/lixuanfengs
 */
@Data
public class ApiAccessLogExcelVO {

    @ExcelProperty("日志主键")
    private Long id;

    @ExcelProperty("链路追踪编号")
    private String traceId;

    @ExcelProperty("用户编号")
    private Long userId;

    @ExcelProperty(value = "用户类型", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.USER_TYPE)
    private Integer userType;

    @ExcelProperty("应用名")
    private String applicationName;

    @ExcelProperty("请求方法名")
    private String requestMethod;

    @ExcelProperty("请求地址")
    private String requestUrl;

    @ExcelProperty("请求参数")
    private String requestParams;

    @ExcelProperty("用户 IP")
    private String userIp;

    @ExcelProperty("浏览器 UA")
    private String userAgent;

    @ExcelProperty("开始请求时间")
    private LocalDateTime beginTime;

    @ExcelProperty("结束请求时间")
    private LocalDateTime endTime;

    @ExcelProperty("执行时长")
    private Integer duration;

    @ExcelProperty("结果码")
    private Integer resultCode;

    @ExcelProperty("结果提示")
    private String resultMsg;

}
