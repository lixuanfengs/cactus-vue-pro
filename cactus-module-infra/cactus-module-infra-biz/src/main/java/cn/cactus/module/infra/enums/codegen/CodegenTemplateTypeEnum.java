package cn.cactus.module.infra.enums.codegen;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.infra.enums.config
 * Description:
 * 代码生成模板类型
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:42
 * @Github https://github.com/lixuanfengs
 */
@AllArgsConstructor
@Getter
public enum CodegenTemplateTypeEnum {

    CRUD(1), // 单表（增删改查）
    TREE(2), // 树表（增删改查）
    ;

    /**
     * 类型
     */
    private final Integer type;

}
