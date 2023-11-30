package cn.cactus.framework.datapermission.core.rule.dept;

/**
 * Package: cn.cactus.framework.datapermission.core.rule.dept
 * Description:
 * {@link DeptDataPermissionRule} 的自定义配置接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 9:21
 * @Github https://github.com/lixuanfengs
 */
@FunctionalInterface
public interface DeptDataPermissionRuleCustomizer {

    /**
     * 自定义该权限规则
     * 1. 调用 {@link DeptDataPermissionRule#addDeptColumn(Class, String)} 方法，配置基于 dept_id 的过滤规则
     * 2. 调用 {@link DeptDataPermissionRule#addUserColumn(Class, String)} 方法，配置基于 user_id 的过滤规则
     *
     * @param rule 权限规则
     */
    void customize(DeptDataPermissionRule rule);

}
