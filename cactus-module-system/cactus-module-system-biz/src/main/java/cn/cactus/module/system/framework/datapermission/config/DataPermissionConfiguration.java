package cn.cactus.module.system.framework.datapermission.config;

import cn.cactus.framework.datapermission.core.rule.dept.DeptDataPermissionRuleCustomizer;
import cn.cactus.module.system.dal.dataobject.dept.DeptDO;
import cn.cactus.module.system.dal.dataobject.user.AdminUserDO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Package: cn.cactus.module.system.framework.datapermission.config
 * Description:
 * system 模块的数据权限 Configuration
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 10:01
 * @Github https://github.com/lixuanfengs
 */
@Configuration(proxyBeanMethods = false)
public class DataPermissionConfiguration {

    @Bean
    public DeptDataPermissionRuleCustomizer sysDeptDataPermissionRuleCustomizer() {
        return rule -> {
            // dept
            rule.addDeptColumn(AdminUserDO.class);
            rule.addDeptColumn(DeptDO.class, "id");
            // user
            rule.addUserColumn(AdminUserDO.class, "id");
        };
    }

}