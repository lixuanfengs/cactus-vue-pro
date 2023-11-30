package cn.cactus.framework.datapermission.config;

import cn.cactus.framework.datapermission.core.rule.dept.DeptDataPermissionRule;
import cn.cactus.framework.datapermission.core.rule.dept.DeptDataPermissionRuleCustomizer;
import cn.cactus.framework.security.core.LoginUser;
import cn.cactus.module.system.api.permission.PermissionApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * Package: cn.cactus.framework.datapermission.config
 * Description:
 * 基于部门的数据权限 AutoConfiguration
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 9:48
 * @Github https://github.com/lixuanfengs
 */
@AutoConfiguration
@ConditionalOnClass(LoginUser.class)
@ConditionalOnBean(value = {PermissionApi.class, DeptDataPermissionRuleCustomizer.class})
public class CactusDeptDataPermissionAutoConfiguration {

    @Bean
    public DeptDataPermissionRule deptDataPermissionRule(PermissionApi permissionApi,
                                                         List<DeptDataPermissionRuleCustomizer> customizers) {
        // 创建 DeptDataPermissionRule 对象
        DeptDataPermissionRule rule = new DeptDataPermissionRule(permissionApi);
        // 补全表配置
        customizers.forEach(customizer -> customizer.customize(rule));
        return rule;
    }

}