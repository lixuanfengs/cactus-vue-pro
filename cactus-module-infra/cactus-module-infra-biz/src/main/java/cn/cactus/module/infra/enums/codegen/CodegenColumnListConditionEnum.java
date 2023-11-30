package cn.cactus.module.infra.enums.codegen;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.infra.enums.config
 * Description:
 * 代码生成器的字段过滤条件枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:41
 * @Github https://github.com/lixuanfengs
 */
@AllArgsConstructor
@Getter
public enum CodegenColumnListConditionEnum {

    EQ("="),
    NE("!="),
    GT(">"),
    GTE(">="),
    LT("<"),
    LTE("<="),
    LIKE("LIKE"),
    BETWEEN("BETWEEN");

    /**
     * 条件
     */
    private final String condition;

}

