package cn.cactus.framework.desensitize.core.regex.annotation;

import cn.cactus.framework.desensitize.core.base.annotation.DesensitizeBy;
import cn.cactus.framework.desensitize.core.regex.handler.EmailDesensitizationHandler;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.*;

/**
 * Package: cn.cactus.framework.desensitize.core.regex.annotation
 * Description:
 * 邮箱脱敏注解
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 14:49
 * @Github https://github.com/lixuanfengs
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = EmailDesensitizationHandler.class)
public @interface EmailDesensitize {

    /**
     * 匹配的正则表达式
     */
    String regex() default "(^.)[^@]*(@.*$)";

    /**
     * 替换规则，邮箱;
     *
     * 比如：example@gmail.com 脱敏之后为 e****@gmail.com
     */
    String replacer() default "$1****$2";
}
