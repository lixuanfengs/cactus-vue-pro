package cn.cactus.framework.security.core.aop;

import cn.cactus.framework.security.core.annotaions.PreAuthenticated;
import cn.cactus.framework.security.core.util.SecurityFrameworkUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import static cn.cactus.framework.common.exception.enums.GlobalErrorCodeConstants.UNAUTHORIZED;
import static cn.cactus.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * Package: cn.cactus.framework.security.core.aop
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 10:52
 * @Github https://github.com/lixuanfengs
 */
@Aspect
@Slf4j
public class PreAuthenticatedAspect {

    @Around("@annotation(preAuthenticated)")
    public Object around(ProceedingJoinPoint joinPoint, PreAuthenticated preAuthenticated) throws Throwable {
        if (SecurityFrameworkUtils.getLoginUser() == null) {
            throw exception(UNAUTHORIZED);
        }
        return joinPoint.proceed();
    }
}
