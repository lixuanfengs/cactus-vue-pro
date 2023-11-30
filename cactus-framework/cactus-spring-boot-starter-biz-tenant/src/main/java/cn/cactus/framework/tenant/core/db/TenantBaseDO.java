package cn.cactus.framework.tenant.core.db;

import cn.cactus.framework.mybatis.core.dataobject.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Package: cn.cactus.framework.tenant.core.db
 * Description:
 * 拓展多租户的 BaseDO 基类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 16:51
 * @Github https://github.com/lixuanfengs
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TenantBaseDO extends BaseDO {

    /**
     * 多租户编号
     */
    private Long tenantId;

}
