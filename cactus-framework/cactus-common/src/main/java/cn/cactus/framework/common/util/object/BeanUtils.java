package cn.cactus.framework.common.util.object;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.common.util.collection.CollectionUtils;
import cn.hutool.core.bean.BeanUtil;

import java.util.List;

/**
 * Package: cn.cactus.framework.common.util.object
 * Description:
 * Bean 工具类
 *
 * 1. 默认使用 {@link cn.hutool.core.bean.BeanUtil} 作为实现类，虽然不同 bean 工具的性能有差别，但是对绝大多数同学的项目，不用在意这点性能
 * 2. 针对复杂的对象转换，可以搜参考 AuthConvert 实现，通过 mapstruct + default 配合实现
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 15:53
 * @Github https://github.com/lixuanfengs
 */
public class BeanUtils {

    public static <T> T toBean(Object source, Class<T> targetClass) {
        return BeanUtil.toBean(source, targetClass);
    }

    public static <S, T> List<T> toBean(List<S> source, Class<T> targetType) {
        if (source == null) {
            return null;
        }
        return CollectionUtils.convertList(source, s -> toBean(s, targetType));
    }

    public static  <S, T> PageResult<T> toBean(PageResult<S> source, Class<T> targetType) {
        if (source == null) {
            return null;
        }
        return new PageResult<>(toBean(source.getList(), targetType), source.getTotal());
    }

}
