package cn.cactus.framework.desensitize.core.slider.handler;

import cn.cactus.framework.desensitize.core.slider.annotation.BankCardDesensitize;

/**
 * Package: cn.cactus.framework.desensitize.core.slider.handler
 * Description:
 * {@link BankCardDesensitize} 的脱敏处理器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 14:58
 * @Github https://github.com/lixuanfengs
 */
public class BankCardDesensitization extends AbstractSliderDesensitizationHandler<BankCardDesensitize> {

    @Override
    Integer getPrefixKeep(BankCardDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(BankCardDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(BankCardDesensitize annotation) {
        return annotation.replacer();
    }

}

