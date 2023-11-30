package cn.cactus.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.framework.common.enums
 * Description:
 *  文档地址
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/9 9:43
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum DocumentEnum {

    REDIS_INSTALL("https://cactusli.net/", "Redis 安装文档"),
    TENANT("https://cactusli.net/", "SaaS 多租户文档");

    private final String url;
    private final String memo;
}
