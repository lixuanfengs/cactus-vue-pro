package cn.cactus.framework.lock4j.core;

import cn.cactus.framework.common.exception.ServiceException;
import cn.cactus.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.baomidou.lock.LockFailureStrategy;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * Package: cn.cactus.framework.lock4j.core
 * Description:
 * 自定义获取锁失败策略，抛出 {@link ServiceException} 异常
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:45
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
public class DefaultLockFailureStrategy implements LockFailureStrategy {

    @Override
    public void onLockFailure(String key, Method method, Object[] arguments) {
        log.debug("[onLockFailure][线程:{} 获取锁失败，key:{} 获取失败:{} ]", Thread.currentThread().getName(), key, arguments);
        throw new ServiceException(GlobalErrorCodeConstants.LOCKED);
    }
}
