package cn.cactus.framework.desensitize.core.slider.annotation;

import cn.cactus.framework.desensitize.core.base.annotation.DesensitizeBy;
import cn.cactus.framework.desensitize.core.slider.handler.MobileDesensitization;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.*;

/**
 * Package: cn.cactus.framework.desensitize.core.slider.annotation
 * Description:
 * 手机号
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 14:56
 * @Github https://github.com/lixuanfengs
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = MobileDesensitization.class)
public @interface MobileDesensitize {

    /**
     * 前缀保留长度
     */
    int prefixKeep() default 3;

    /**
     * 后缀保留长度
     */
    int suffixKeep() default 4;

    /**
     * 替换规则，手机号;比如：13248765917 脱敏之后为 132****5917
     */
    String replacer() default "*";

}
