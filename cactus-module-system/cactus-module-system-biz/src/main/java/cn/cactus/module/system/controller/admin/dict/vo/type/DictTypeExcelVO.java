package cn.cactus.module.system.controller.admin.dict.vo.type;

import cn.cactus.framework.excel.core.annotations.DictFormat;
import cn.cactus.framework.excel.core.convert.DictConvert;
import cn.cactus.module.system.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * Package: cn.cactus.module.system.controller.admin.dict.vo.type
 * Description:
 * 字典类型 Excel 导出响应 VO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/15 10:33
 * @Github https://github.com/lixuanfengs
 */
@Data
public class DictTypeExcelVO {

    @ExcelProperty("字典主键")
    private Long id;

    @ExcelProperty("字典名称")
    private String name;

    @ExcelProperty("字典类型")
    private String type;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

}
