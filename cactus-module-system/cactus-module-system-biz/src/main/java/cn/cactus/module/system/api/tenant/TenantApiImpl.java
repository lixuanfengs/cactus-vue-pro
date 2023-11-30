package cn.cactus.module.system.api.tenant;

import cn.cactus.module.system.service.tenant.TenantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Package: cn.cactus.module.system.api.tenant
 * Description:
 * 多租户的 API 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:58
 * @Github https://github.com/lixuanfengs
 */
@Service
public class TenantApiImpl implements TenantApi {

    @Resource
    private TenantService tenantService;

    @Override
    public List<Long> getTenantIdList() {
        return tenantService.getTenantIdList();
    }

    @Override
    public void validateTenant(Long id) {
        tenantService.validTenant(id);
    }

}
