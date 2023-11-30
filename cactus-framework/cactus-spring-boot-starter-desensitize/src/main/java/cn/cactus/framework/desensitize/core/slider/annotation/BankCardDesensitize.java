package cn.cactus.framework.desensitize.core.slider.annotation;

import cn.cactus.framework.desensitize.core.base.annotation.DesensitizeBy;
import cn.cactus.framework.desensitize.core.slider.handler.BankCardDesensitization;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.*;

/**
 * Package: cn.cactus.framework.desensitize.core.slider.annotation
 * Description:
 * 银行卡号
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 14:54
 * @Github https://github.com/lixuanfengs
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = BankCardDesensitization.class)
public @interface BankCardDesensitize {

    /**
     * 前缀保留长度
     */
    int prefixKeep() default 6;

    /**
     * 后缀保留长度
     */
    int suffixKeep() default 2;

    /**
     * 替换规则，银行卡号; 比如：9988002866797031 脱敏之后为 998800********31
     */
    String replacer() default "*";

}
