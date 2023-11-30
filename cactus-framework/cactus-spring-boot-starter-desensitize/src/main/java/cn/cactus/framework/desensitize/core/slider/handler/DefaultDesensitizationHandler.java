package cn.cactus.framework.desensitize.core.slider.handler;

import cn.cactus.framework.desensitize.core.slider.annotation.SliderDesensitize;

/**
 * Package: cn.cactus.framework.desensitize.core.slider.handler
 * Description:
 * {@link SliderDesensitize} 的脱敏处理器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:00
 * @Github https://github.com/lixuanfengs
 */
public class DefaultDesensitizationHandler extends AbstractSliderDesensitizationHandler<SliderDesensitize> {
    @Override
    Integer getPrefixKeep(SliderDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(SliderDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(SliderDesensitize annotation) {
        return annotation.replacer();
    }
}

