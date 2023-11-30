package cn.cactus.framework.desensitize.core.slider.annotation;

import cn.cactus.framework.desensitize.core.base.annotation.DesensitizeBy;
import cn.cactus.framework.desensitize.core.slider.handler.ChineseNameDesensitization;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.*;

/**
 * Package: cn.cactus.framework.desensitize.core.slider.annotation
 * Description:
 * 中文名
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 14:55
 * @Github https://github.com/lixuanfengs
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = ChineseNameDesensitization.class)
public @interface ChineseNameDesensitize {

    /**
     * 前缀保留长度
     */
    int prefixKeep() default 1;

    /**
     * 后缀保留长度
     */
    int suffixKeep() default 0;

    /**
     * 替换规则，中文名;比如：刘子豪脱敏之后为刘**
     */
    String replacer() default "*";

}
