package cn.cactus.module.infra.enums.logger;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.infra.enums.logger
 * Description:
 * API 异常数据的处理状态
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 17:40
 * @Github https://github.com/lixuanfengs
 */
@AllArgsConstructor
@Getter
public enum ApiErrorLogProcessStatusEnum {

    INIT(0, "未处理"),
    DONE(1, "已处理"),
    IGNORE(2, "已忽略");

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 资源类型名
     */
    private final String name;

}
