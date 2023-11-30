package cn.cactus.module.system.controller.admin.tenant.vo.tenant;

import cn.cactus.framework.excel.core.annotations.DictFormat;
import cn.cactus.framework.excel.core.convert.DictConvert;
import cn.cactus.module.system.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.system.controller.admin.tenant.vo.tenant
 * Description:
 * 租户 Excel VO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:57
 * @Github https://github.com/lixuanfengs
 */
@Data
public class TenantExcelVO {

    @ExcelProperty("租户编号")
    private Long id;

    @ExcelProperty("租户名")
    private String name;

    @ExcelProperty("联系人")
    private String contactName;

    @ExcelProperty("联系手机")
    private String contactMobile;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
