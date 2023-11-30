package cn.cactus.module.system.controller.admin.dict.vo.data;

import cn.cactus.framework.excel.core.annotations.DictFormat;
import cn.cactus.framework.excel.core.convert.DictConvert;
import cn.cactus.module.system.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * Package: cn.cactus.module.system.controller.admin.dict.vo.data
 * Description:
 * 字典数据 Excel 导出响应 VO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/15 10:28
 * @Github https://github.com/lixuanfengs
 */
@Data
public class DictDataExcelVO {

    @ExcelProperty("字典编码")
    private Long id;

    @ExcelProperty("字典排序")
    private Integer sort;

    @ExcelProperty("字典标签")
    private String label;

    @ExcelProperty("字典键值")
    private String value;

    @ExcelProperty("字典类型")
    private String dictType;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

}
