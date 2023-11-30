package cn.cactus.framework.desensitize.core.slider.handler;

import cn.cactus.framework.desensitize.core.slider.annotation.IdCardDesensitize;

/**
 * Package: cn.cactus.framework.desensitize.core.slider.handler
 * Description:
 * {@link IdCardDesensitize} 的脱敏处理器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:00
 * @Github https://github.com/lixuanfengs
 */
public class IdCardDesensitization extends AbstractSliderDesensitizationHandler<IdCardDesensitize> {
    @Override
    Integer getPrefixKeep(IdCardDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(IdCardDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(IdCardDesensitize annotation) {
        return annotation.replacer();
    }
}
