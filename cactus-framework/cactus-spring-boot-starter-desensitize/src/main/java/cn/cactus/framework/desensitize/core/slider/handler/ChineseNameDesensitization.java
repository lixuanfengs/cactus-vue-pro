package cn.cactus.framework.desensitize.core.slider.handler;

import cn.cactus.framework.desensitize.core.slider.annotation.ChineseNameDesensitize;

/**
 * Package: cn.cactus.framework.desensitize.core.slider.handler
 * Description:
 * {@link ChineseNameDesensitize} 的脱敏处理器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 14:59
 * @Github https://github.com/lixuanfengs
 */
public class ChineseNameDesensitization extends AbstractSliderDesensitizationHandler<ChineseNameDesensitize> {

    @Override
    Integer getPrefixKeep(ChineseNameDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(ChineseNameDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(ChineseNameDesensitize annotation) {
        return annotation.replacer();
    }

}

