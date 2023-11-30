package cn.cactus.framework.desensitize.core.slider.handler;

import cn.cactus.framework.desensitize.core.slider.annotation.CarLicenseDesensitize;

/**
 * Package: cn.cactus.framework.desensitize.core.slider.handler
 * Description:
 * {@link CarLicenseDesensitize} 的脱敏处理器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 14:58
 * @Github https://github.com/lixuanfengs
 */
public class CarLicenseDesensitization extends AbstractSliderDesensitizationHandler<CarLicenseDesensitize> {
    @Override
    Integer getPrefixKeep(CarLicenseDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getSuffixKeep(CarLicenseDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getReplacer(CarLicenseDesensitize annotation) {
        return annotation.replacer();
    }
}

