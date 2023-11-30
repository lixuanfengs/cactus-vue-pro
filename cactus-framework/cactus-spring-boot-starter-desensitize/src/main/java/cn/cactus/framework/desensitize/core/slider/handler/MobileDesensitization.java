package cn.cactus.framework.desensitize.core.slider.handler;

import cn.cactus.framework.desensitize.core.slider.annotation.MobileDesensitize;

/**
 * Package: cn.cactus.framework.desensitize.core.slider.handler
 * Description:
 * {@link MobileDesensitize} 的脱敏处理器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:00
 * @Github https://github.com/lixuanfengs
 */
public class MobileDesensitization extends AbstractSliderDesensitizationHandler<MobileDesensitize> {

    @Override
    Integer getPrefixKeep(MobileDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(MobileDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(MobileDesensitize annotation) {
        return annotation.replacer();
    }
}