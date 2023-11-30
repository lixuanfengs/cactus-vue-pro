package cn.cactus.module.system.controller.admin.permission.vo.role;

import cn.cactus.framework.excel.core.annotations.DictFormat;
import cn.cactus.framework.excel.core.convert.DictConvert;
import cn.cactus.module.system.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * Package: cn.cactus.module.system.controller.admin.permission.vo.role
 * Description:
 * 角色 Excel 导出响应 VO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 11:05
 * @Github https://github.com/lixuanfengs
 */
@Data
public class RoleExcelVO {

    @ExcelProperty("角色序号")
    private Long id;

    @ExcelProperty("角色名称")
    private String name;

    @ExcelProperty("角色标志")
    private String code;

    @ExcelProperty("角色排序")
    private Integer sort;

    @ExcelProperty("数据范围")
    private Integer dataScope;

    @ExcelProperty(value = "角色状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private String status;

}
