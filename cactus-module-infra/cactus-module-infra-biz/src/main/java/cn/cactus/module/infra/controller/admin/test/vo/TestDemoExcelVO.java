package cn.cactus.module.infra.controller.admin.test.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.infra.controller.admin.test.vo
 * Description:
 * 字典类型 Excel VO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:07
 * @Github https://github.com/lixuanfengs
 */
@Data
public class TestDemoExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("名字")
    private String name;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("类型")
    private Integer type;

    @ExcelProperty("分类")
    private Integer category;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
