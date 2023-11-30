package cn.cactus.module.infra.controller.admin.codegen.vo.column;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.infra.controller.admin.codegen.vo.column
 * Description:
 * 代码生成字段定义 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:57
 * @Github https://github.com/lixuanfengs
 */
@Data
public class CodegenColumnBaseVO {

    @Schema(description = "表编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "表编号不能为空")
    private Long tableId;

    @Schema(description = "字段名", requiredMode = Schema.RequiredMode.REQUIRED, example = "user_age")
    @NotNull(message = "字段名不能为空")
    private String columnName;

    @Schema(description = "字段类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "int(11)")
    @NotNull(message = "字段类型不能为空")
    private String dataType;

    @Schema(description = "字段描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "年龄")
    @NotNull(message = "字段描述不能为空")
    private String columnComment;

    @Schema(description = "是否允许为空", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "是否允许为空不能为空")
    private Boolean nullable;

    @Schema(description = "是否主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "是否主键不能为空")
    private Boolean primaryKey;

    @Schema(description = "是否自增", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "是否自增不能为空")
    private String autoIncrement;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "排序不能为空")
    private Integer ordinalPosition;

    @Schema(description = "Java 属性类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "userAge")
    @NotNull(message = "Java 属性类型不能为空")
    private String javaType;

    @Schema(description = "Java 属性名", requiredMode = Schema.RequiredMode.REQUIRED, example = "Integer")
    @NotNull(message = "Java 属性名不能为空")
    private String javaField;

    @Schema(description = "字典类型", example = "sys_gender")
    private String dictType;

    @Schema(description = "数据示例", example = "1024")
    private String example;

    @Schema(description = "是否为 Create 创建操作的字段", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "是否为 Create 创建操作的字段不能为空")
    private Boolean createOperation;

    @Schema(description = "是否为 Update 更新操作的字段", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "是否为 Update 更新操作的字段不能为空")
    private Boolean updateOperation;

    @Schema(description = "是否为 List 查询操作的字段", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "是否为 List 查询操作的字段不能为空")
    private Boolean listOperation;

    @Schema(description = "List 查询操作的条件类型，参见 CodegenColumnListConditionEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "LIKE")
    @NotNull(message = "List 查询操作的条件类型不能为空")
    private String listOperationCondition;

    @Schema(description = "是否为 List 查询操作的返回字段", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "是否为 List 查询操作的返回字段不能为空")
    private Boolean listOperationResult;

    @Schema(description = "显示类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "input")
    @NotNull(message = "显示类型不能为空")
    private String htmlType;

}