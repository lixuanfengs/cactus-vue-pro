package cn.cactus.module.infra.enums.codegen;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static cn.hutool.core.util.ArrayUtil.firstMatch;

/**
 * Package: cn.cactus.module.infra.enums.config
 * Description:
 * 代码生成的场景枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:42
 * @Github https://github.com/lixuanfengs
 */
@AllArgsConstructor
@Getter
public enum CodegenSceneEnum {

    ADMIN(1, "管理后台", "admin", ""),
    APP(2, "用户 APP", "app", "App");

    /**
     * 场景
     */
    private final Integer scene;
    /**
     * 场景名
     */
    private final String name;
    /**
     * 基础包名
     */
    private final String basePackage;
    /**
     * Controller 和 VO 类的前缀
     */
    private final String prefixClass;

    public static CodegenSceneEnum valueOf(Integer scene) {
        return firstMatch(sceneEnum -> sceneEnum.getScene().equals(scene), values());
    }

}

