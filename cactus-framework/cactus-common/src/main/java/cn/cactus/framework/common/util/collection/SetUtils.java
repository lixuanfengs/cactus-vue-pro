package cn.cactus.framework.common.util.collection;

import cn.hutool.core.collection.CollUtil;

import java.util.Set;

/**
 * Package: cn.cactus.framework.common.util.collection
 * Description:
 * Set 工具类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/10 10:10
 * @Github https://github.com/lixuanfengs
 */
public class SetUtils {

    @SafeVarargs
    public static <T> Set<T> asSet(T... objs) {
        return CollUtil.newHashSet(objs);
    }

}
