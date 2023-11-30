package cn.cactus.framework.datapermission.core.aop;

import cn.cactus.framework.datapermission.core.annotation.DataPermission;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

/**
 * Package: cn.cactus.framework.datapermission.core.aop
 * Description:
 * {@link cn.cactus.framework.datapermission.core.annotation.DataPermission} 注解的 Advisor 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:32
 * @Github https://github.com/lixuanfengs
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class DataPermissionAnnotationAdvisor extends AbstractPointcutAdvisor {

    private final Advice advice;

    private final Pointcut pointcut;

    public DataPermissionAnnotationAdvisor() {
        this.advice = new DataPermissionAnnotationInterceptor();
        this.pointcut = this.buildPointcut();
    }

    protected Pointcut buildPointcut() {
        Pointcut classPointcut = new AnnotationMatchingPointcut(DataPermission.class, true);
        Pointcut methodPointcut = new AnnotationMatchingPointcut(null, DataPermission.class, true);
        return new ComposablePointcut(classPointcut).union(methodPointcut);
    }

}