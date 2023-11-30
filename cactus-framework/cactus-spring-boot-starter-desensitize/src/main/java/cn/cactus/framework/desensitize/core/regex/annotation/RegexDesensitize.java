package cn.cactus.framework.desensitize.core.regex.annotation;

import cn.cactus.framework.desensitize.core.base.annotation.DesensitizeBy;
import cn.cactus.framework.desensitize.core.regex.handler.DefaultRegexDesensitizationHandler;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.*;

/**
 * Package: cn.cactus.framework.desensitize.core.regex.annotation
 * Description:
 * 正则脱敏注解
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 14:50
 * @Github https://github.com/lixuanfengs
 */
@Documented
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = DefaultRegexDesensitizationHandler.class)
public @interface RegexDesensitize {

    /**
     * 匹配的正则表达式（默认匹配所有）
     */
    String regex() default "^[\\s\\S]*$";

    /**
     * 替换规则，会将匹配到的字符串全部替换成 replacer
     *
     * 例如：regex=123; replacer=******
     * 原始字符串 123456789
     * 脱敏后字符串 ******456789
     */
    String replacer() default "******";
}
