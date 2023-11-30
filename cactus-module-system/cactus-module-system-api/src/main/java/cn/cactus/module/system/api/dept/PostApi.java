package cn.cactus.module.system.api.dept;

import java.util.Collection;

/**
 * Package: cn.cactus.module.system.api.dept
 * Description:
 * 岗位 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:11
 * @Github https://github.com/lixuanfengs
 */
public interface PostApi {

    /**
     * 校验岗位们是否有效。如下情况，视为无效：
     * 1. 岗位编号不存在
     * 2. 岗位被禁用
     *
     * @param ids 岗位编号数组
     */
    void validPostList(Collection<Long> ids);
}
