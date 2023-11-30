package cn.cactus.framework.desensitize.core.regex.handler;

import cn.cactus.framework.desensitize.core.regex.annotation.EmailDesensitize;

/**
 * Package: cn.cactus.framework.desensitize.core.regex.handler
 * Description:
 * {@link EmailDesensitize} 的脱敏处理器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 14:51
 * @Github https://github.com/lixuanfengs
 */
public class EmailDesensitizationHandler extends AbstractRegexDesensitizationHandler<EmailDesensitize> {

    @Override
    String getRegex(EmailDesensitize annotation) {
        return annotation.regex();
    }

    @Override
    String getReplacer(EmailDesensitize annotation) {
        return annotation.replacer();
    }

}
