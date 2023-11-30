package cn.cactus.framework.idempotent.core.keyresolver;

import cn.cactus.framework.idempotent.core.annotation.Idempotent;
import org.aspectj.lang.JoinPoint;

/**
 * Package: cn.cactus.framework.idempotent.core.keyresolver
 * Description:
 * 幂等 Key 解析器接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:42
 * @Github https://github.com/lixuanfengs
 */
public interface IdempotentKeyResolver {

    /**
     * 解析一个 Key
     *
     * @param idempotent 幂等注解
     * @param joinPoint  AOP 切面
     * @return Key
     */
    String resolver(JoinPoint joinPoint, Idempotent idempotent);

}
