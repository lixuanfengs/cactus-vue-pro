package cn.cactus.framework.desensitize.core.slider.handler;

import cn.cactus.framework.desensitize.core.slider.annotation.FixedPhoneDesensitize;

/**
 * Package: cn.cactus.framework.desensitize.core.slider.handler
 * Description:
 * {@link FixedPhoneDesensitize} 的脱敏处理器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:00
 * @Github https://github.com/lixuanfengs
 */
public class FixedPhoneDesensitization extends AbstractSliderDesensitizationHandler<FixedPhoneDesensitize> {
    @Override
    Integer getPrefixKeep(FixedPhoneDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(FixedPhoneDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(FixedPhoneDesensitize annotation) {
        return annotation.replacer();
    }
}
