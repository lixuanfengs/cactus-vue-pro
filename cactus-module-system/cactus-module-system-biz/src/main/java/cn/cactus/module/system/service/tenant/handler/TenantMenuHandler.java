package cn.cactus.module.system.service.tenant.handler;

import java.util.Set;

/**
 * Package: cn.cactus.module.system.service.tenant.handler
 * Description:
 * 租户菜单处理
 * 目的：尽量减少租户逻辑耦合到系统中
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:37
 * @Github https://github.com/lixuanfengs
 */
public interface TenantMenuHandler {

    /**
     * 基于传入的租户菜单【全】列表，进行相关逻辑的执行
     * 例如说，返回可分配菜单的时候，可以移除多余的
     *
     * @param menuIds 菜单列表
     */
    void handle(Set<Long> menuIds);

}
