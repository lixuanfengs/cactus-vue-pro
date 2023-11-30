package cn.cactus.framework.idempotent.core.keyresolver.impl;

import cn.cactus.framework.idempotent.core.annotation.Idempotent;
import cn.cactus.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import org.aspectj.lang.JoinPoint;

/**
 * Package: cn.cactus.framework.idempotent.core.keyresolver.impl
 * Description:
 * 默认幂等 Key 解析器，使用方法名 + 方法参数，组装成一个 Key
 *
 * 为了避免 Key 过长，使用 MD5 进行“压缩”
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:43
 * @Github https://github.com/lixuanfengs
 */
public class DefaultIdempotentKeyResolver implements IdempotentKeyResolver {

    @Override
    public String resolver(JoinPoint joinPoint, Idempotent idempotent) {
        String methodName = joinPoint.getSignature().toString();
        String argsStr = StrUtil.join(",", joinPoint.getArgs());
        return SecureUtil.md5(methodName + argsStr);
    }

}