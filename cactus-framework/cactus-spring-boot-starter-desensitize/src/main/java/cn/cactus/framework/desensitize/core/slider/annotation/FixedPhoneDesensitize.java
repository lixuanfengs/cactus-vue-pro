package cn.cactus.framework.desensitize.core.slider.annotation;

import cn.cactus.framework.desensitize.core.base.annotation.DesensitizeBy;
import cn.cactus.framework.desensitize.core.slider.handler.FixedPhoneDesensitization;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.*;

/**
 * Package: cn.cactus.framework.desensitize.core.slider.annotation
 * Description:
 * 固定电话
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 14:55
 * @Github https://github.com/lixuanfengs
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = FixedPhoneDesensitization.class)
public @interface FixedPhoneDesensitize {

    /**
     * 前缀保留长度
     */
    int prefixKeep() default 4;

    /**
     * 后缀保留长度
     */
    int suffixKeep() default 2;

    /**
     * 替换规则，固定电话;比如：01086551122 脱敏之后为 0108*****22
     */
    String replacer() default "*";

}