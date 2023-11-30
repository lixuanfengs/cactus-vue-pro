package cn.cactus.framework.idempotent.core.aop;

import cn.cactus.framework.common.exception.ServiceException;
import cn.cactus.framework.common.exception.enums.GlobalErrorCodeConstants;
import cn.cactus.framework.common.util.collection.CollectionUtils;
import cn.cactus.framework.idempotent.core.annotation.Idempotent;
import cn.cactus.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import cn.cactus.framework.idempotent.core.redis.IdempotentRedisDAO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * Package: cn.cactus.framework.idempotent.core.aop
 * Description:
 * 拦截声明了 {@link Idempotent} 注解的方法，实现幂等操作
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:42
 * @Github https://github.com/lixuanfengs
 */
@Aspect
@Slf4j
public class IdempotentAspect {

    /**
     * IdempotentKeyResolver 集合
     */
    private final Map<Class<? extends IdempotentKeyResolver>, IdempotentKeyResolver> keyResolvers;

    private final IdempotentRedisDAO idempotentRedisDAO;

    public IdempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        this.keyResolvers = CollectionUtils.convertMap(keyResolvers, IdempotentKeyResolver::getClass);
        this.idempotentRedisDAO = idempotentRedisDAO;
    }

    @Before("@annotation(idempotent)")
    public void beforePointCut(JoinPoint joinPoint, Idempotent idempotent) {
        // 获得 IdempotentKeyResolver
        IdempotentKeyResolver keyResolver = keyResolvers.get(idempotent.keyResolver());
        Assert.notNull(keyResolver, "找不到对应的 IdempotentKeyResolver");
        // 解析 Key
        String key = keyResolver.resolver(joinPoint, idempotent);

        // 锁定 Key。
        boolean success = idempotentRedisDAO.setIfAbsent(key, idempotent.timeout(), idempotent.timeUnit());
        // 锁定失败，抛出异常
        if (!success) {
            log.info("[beforePointCut][方法({}) 参数({}) 存在重复请求]", joinPoint.getSignature().toString(), joinPoint.getArgs());
            throw new ServiceException(GlobalErrorCodeConstants.REPEATED_REQUESTS.getCode(), idempotent.message());
        }
    }

}

