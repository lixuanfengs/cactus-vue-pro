package cn.cactus.framework.sms.core.client;

import cn.cactus.framework.common.exception.ErrorCode;
import cn.cactus.framework.sms.core.enums.SmsFrameworkErrorCodeConstants;

import java.util.function.Function;

/**
 * Package: cn.cactus.framework.sms.core.client
 * Description:
 * 将 API 的错误码，转换为通用的错误码
 *
 * @see SmsCommonResult
 * @see SmsFrameworkErrorCodeConstants
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 16:38
 * @Github https://github.com/lixuanfengs
 */
public interface SmsCodeMapping extends Function<String, ErrorCode> {
}
