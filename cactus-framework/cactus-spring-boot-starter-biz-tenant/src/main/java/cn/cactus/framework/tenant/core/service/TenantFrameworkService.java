package cn.cactus.framework.tenant.core.service;

import java.util.List;

/**
 * Package: cn.cactus.framework.tenant.core.service
 * Description:
 * Tenant 框架 Service 接口，定义获取租户信息
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 16:55
 * @Github https://github.com/lixuanfengs
 */
public interface TenantFrameworkService {

    /**
     * 获得所有租户
     *
     * @return 租户编号数组
     */
    List<Long> getTenantIds();

    /**
     * 校验租户是否合法
     *
     * @param id 租户编号
     */
    void validTenant(Long id);
}
