package cn.cactus.framework.security.core.annotaions;

import java.lang.annotation.*;

/**
 * Package: cn.cactus.framework.security.core.annotaions
 * Description:
 * 声明用户需要登录
 * 为什么不使用 {@link org.springframework.security.access.prepost.PreAuthorize} 注解，原因是不通过时，抛出的是认证不通过，而不是未登录
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 10:50
 * @Github https://github.com/lixuanfengs
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PreAuthenticated {
}
