package cn.cactus.framework.sms.core.client.impl.debug;

import cn.cactus.framework.common.exception.ErrorCode;
import cn.cactus.framework.common.exception.enums.GlobalErrorCodeConstants;
import cn.cactus.framework.sms.core.client.SmsCodeMapping;
import cn.cactus.framework.sms.core.enums.SmsFrameworkErrorCodeConstants;

import java.util.Objects;

/**
 * Package: cn.cactus.framework.sms.core.client.impl.debug
 * Description:
 * 钉钉的 SmsCodeMapping 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 16:56
 * @Github https://github.com/lixuanfengs
 */
public class DebugDingTalkCodeMapping implements SmsCodeMapping {

    @Override
    public ErrorCode apply(String apiCode) {
        return Objects.equals(apiCode, "0") ? GlobalErrorCodeConstants.SUCCESS : SmsFrameworkErrorCodeConstants.SMS_UNKNOWN;
    }

}
