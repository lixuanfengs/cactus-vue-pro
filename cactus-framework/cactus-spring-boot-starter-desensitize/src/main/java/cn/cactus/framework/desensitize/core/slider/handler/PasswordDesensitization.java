package cn.cactus.framework.desensitize.core.slider.handler;

import cn.cactus.framework.desensitize.core.slider.annotation.PasswordDesensitize;

/**
 * Package: cn.cactus.framework.desensitize.core.slider.handler
 * Description:
 * {@link PasswordDesensitize} 的码脱敏处理器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:01
 * @Github https://github.com/lixuanfengs
 */
public class PasswordDesensitization extends AbstractSliderDesensitizationHandler<PasswordDesensitize> {
    @Override
    Integer getPrefixKeep(PasswordDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(PasswordDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(PasswordDesensitize annotation) {
        return annotation.replacer();
    }
}
