package cn.cactus.framework.tenant.core.job;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Package: cn.cactus.framework.tenant.core.job
 * Description:
 * 多租户 Job 注解
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 16:53
 * @Github https://github.com/lixuanfengs
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TenantJob {
}
