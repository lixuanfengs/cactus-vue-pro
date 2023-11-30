package cn.cactus.module.system.service.tenant.handler;

import cn.cactus.module.system.dal.dataobject.tenant.TenantDO;

/**
 * Package: cn.cactus.module.system.service.tenant.handler
 * Description:
 * 租户信息处理
 * 目的：尽量减少租户逻辑耦合到系统中
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:37
 * @Github https://github.com/lixuanfengs
 */
public interface TenantInfoHandler {

    /**
     * 基于传入的租户信息，进行相关逻辑的执行
     * 例如说，创建用户时，超过最大账户配额
     *
     * @param tenant 租户信息
     */
    void handle(TenantDO tenant);

}

