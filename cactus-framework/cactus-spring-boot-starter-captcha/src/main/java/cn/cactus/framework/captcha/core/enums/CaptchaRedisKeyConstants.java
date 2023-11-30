package cn.cactus.framework.captcha.core.enums;

/**
 * Package: cn.cactus.framework.captcha.core.enums
 * Description:
 * 验证码 Redis Key 枚举类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 10:32
 * @Github https://github.com/lixuanfengs
 */
public interface CaptchaRedisKeyConstants {

    /**
     * 验证码的请求限流
     *
     * KEY 格式：AJ.CAPTCHA.REQ.LIMIT-%s-%s
     * VALUE 数据类型：String // 例如说：验证失败 5 次，get 接口锁定
     * 过期时间：60 秒
     */
    String AJ_CAPTCHA_REQ_LIMIT = "AJ.CAPTCHA.REQ.LIMIT-%s-%s";

    /**
     * 验证码的坐标
     *
     * KEY 格式：RUNNING:CAPTCHA:%s // AbstractCaptchaService.REDIS_CAPTCHA_KEY
     * VALUE 数据类型：String // PointVO.class {"secretKey":"PP1w2Frr2KEejD2m","x":162,"y":5}
     * 过期时间：120 秒
     */
    String AJ_CAPTCHA_RUNNING = "RUNNING:CAPTCHA:%s";
}
