package cn.cactus.framework.desensitize.core.regex.handler;

import cn.cactus.framework.desensitize.core.regex.annotation.RegexDesensitize;

/**
 * Package: cn.cactus.framework.desensitize.core.regex.handler
 * Description:
 * {@link RegexDesensitize} 的正则脱敏处理器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 14:50
 * @Github https://github.com/lixuanfengs
 */
public class DefaultRegexDesensitizationHandler extends AbstractRegexDesensitizationHandler<RegexDesensitize> {

    @Override
    String getRegex(RegexDesensitize annotation) {
        return annotation.regex();
    }

    @Override
    String getReplacer(RegexDesensitize annotation) {
        return annotation.replacer();
    }
}

