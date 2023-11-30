package cn.cactus.module.system.controller.admin.logger.vo.loginlog;

import cn.cactus.framework.excel.core.annotations.DictFormat;
import cn.cactus.framework.excel.core.convert.DictConvert;
import cn.cactus.module.system.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.system.controller.admin.logger.loginlog
 * Description:
 * 登录日志 Excel 导出响应 VO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:35
 * @Github https://github.com/lixuanfengs
 */
@Data
public class LoginLogExcelVO {

    @ExcelProperty("日志主键")
    private Long id;

    @ExcelProperty("用户账号")
    private String username;

    @ExcelProperty(value = "日志类型", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.LOGIN_TYPE)
    private Integer logType;

    @ExcelProperty(value = "登录结果", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.LOGIN_RESULT)
    private Integer result;

    @ExcelProperty("登录 IP")
    private String userIp;

    @ExcelProperty("浏览器 UA")
    private String userAgent;

    @ExcelProperty("登录时间")
    private LocalDateTime createTime;

}
