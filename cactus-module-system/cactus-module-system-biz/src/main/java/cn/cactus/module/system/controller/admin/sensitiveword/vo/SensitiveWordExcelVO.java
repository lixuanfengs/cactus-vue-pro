package cn.cactus.module.system.controller.admin.sensitiveword.vo;

import cn.cactus.framework.excel.core.annotations.DictFormat;
import cn.cactus.framework.excel.core.convert.DictConvert;
import cn.cactus.framework.excel.core.convert.JsonConvert;
import cn.cactus.module.system.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Package: cn.cactus.module.system.controller.admin.sensitiveword.vo
 * Description:
 * 敏感词 Excel VO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 11:11
 * @Github https://github.com/lixuanfengs
 */
@Data
public class SensitiveWordExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("敏感词")
    private String name;

    @ExcelProperty(value = "标签", converter = JsonConvert.class)
    private List<String> tags;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @ExcelProperty("描述")
    private String description;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
