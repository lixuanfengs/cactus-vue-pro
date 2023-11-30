package cn.cactus.framework.datapermission.core.rule;

import java.util.List;

/**
 * Package: cn.cactus.framework.datapermission.core.rule
 * Description:
 * {@link DataPermissionRule} 工厂接口
 * 作为 {@link DataPermissionRule} 的容器，提供管理能力
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 9:31
 * @Github https://github.com/lixuanfengs
 */
public interface DataPermissionRuleFactory {

    /**
     * 获得所有数据权限规则数组
     *
     * @return 数据权限规则数组
     */
    List<DataPermissionRule> getDataPermissionRules();

    /**
     * 获得指定 Mapper 的数据权限规则数组
     *
     * @param mappedStatementId 指定 Mapper 的编号
     * @return 数据权限规则数组
     */
    List<DataPermissionRule> getDataPermissionRule(String mappedStatementId);

}
