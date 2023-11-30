package cn.cactus.framework.quartz.core.enums;

/**
 * Package: cn.cactus.framework.quartz.core.enums
 * Description:
 * Quartz Job Data 的 key 枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 16:17
 * @Github https://github.com/lixuanfengs
 */
public enum JobDataKeyEnum {

    JOB_ID,
    JOB_HANDLER_NAME,
    JOB_HANDLER_PARAM,
    JOB_RETRY_COUNT, // 最大重试次数
    JOB_RETRY_INTERVAL, // 每次重试间隔
}
