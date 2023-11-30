package cn.cactus.module.infra.enums.job;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.module.infra.enums.job
 * Description:
 * 任务日志的状态枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:40
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum JobLogStatusEnum {

    RUNNING(0), // 运行中
    SUCCESS(1), // 成功
    FAILURE(2); // 失败

    /**
     * 状态
     */
    private final Integer status;

}
