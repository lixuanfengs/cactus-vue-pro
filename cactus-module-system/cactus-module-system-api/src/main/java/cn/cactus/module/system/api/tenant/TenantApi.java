package cn.cactus.module.system.api.tenant;

import java.util.List;

/**
 * Package: cn.cactus.module.system.api.tenant
 * Description:
 * 多租户的 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 16:57
 * @Github https://github.com/lixuanfengs
 */
public interface TenantApi {

    /**
     * 获得所有租户
     *
     * @return 租户编号数组
     */
    List<Long> getTenantIdList();

    /**
     * 校验租户是否合法
     *
     * @param id 租户编号
     */
    void validateTenant(Long id);

}
