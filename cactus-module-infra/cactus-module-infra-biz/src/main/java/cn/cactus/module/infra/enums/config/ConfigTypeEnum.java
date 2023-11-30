package cn.cactus.module.infra.enums.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.infra.enums.config
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:41
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum ConfigTypeEnum {

    /**
     * 系统配置
     */
    SYSTEM(1),
    /**
     * 自定义配置
     */
    CUSTOM(2);

    private final Integer type;

}

