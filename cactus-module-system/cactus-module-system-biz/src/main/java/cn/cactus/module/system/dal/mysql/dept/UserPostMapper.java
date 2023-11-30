package cn.cactus.module.system.dal.mysql.dept;

import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.cactus.module.system.dal.dataobject.dept.UserPostDO;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * Package: cn.cactus.module.system.dal.mysql.dept
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:13
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface UserPostMapper extends BaseMapperX<UserPostDO> {

    default List<UserPostDO> selectListByUserId(Long userId) {
        return selectList(UserPostDO::getUserId, userId);
    }

    default void deleteByUserIdAndPostId(Long userId, Collection<Long> postIds) {
        delete(new LambdaQueryWrapperX<UserPostDO>()
                .eq(UserPostDO::getUserId, userId)
                .in(UserPostDO::getPostId, postIds));
    }

    default List<UserPostDO> selectListByPostIds(Collection<Long> postIds) {
        return selectList(UserPostDO::getPostId, postIds);
    }

    default void deleteByUserId(Long userId) {
        delete(Wrappers.lambdaUpdate(UserPostDO.class).eq(UserPostDO::getUserId, userId));
    }
}

