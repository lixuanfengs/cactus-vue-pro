package cn.cactus.framework.idempotent.core.annotation;

import cn.cactus.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import cn.cactus.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * Package: cn.cactus.framework.idempotent.core.annotation
 * Description:
 * 幂等注解
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:41
 * @Github https://github.com/lixuanfengs
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Idempotent {

    /**
     * 幂等的超时时间，默认为 1 秒
     *
     * 注意，如果执行时间超过它，请求还是会进来
     */
    int timeout() default 1;
    /**
     * 时间单位，默认为 SECONDS 秒
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * 提示信息，正在执行中的提示
     */
    String message() default "重复请求，请稍后重试";

    /**
     * 使用的 Key 解析器
     */
    Class<? extends IdempotentKeyResolver> keyResolver() default DefaultIdempotentKeyResolver.class;
    /**
     * 使用的 Key 参数
     */
    String keyArg() default "";

}