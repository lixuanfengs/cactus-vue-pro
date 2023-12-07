package cn.cactus.module.infra.dal.mysql.demo.demo02;

import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.cactus.module.infra.controller.admin.demo.demo02.vo.Demo02CategoryListReqVO;
import cn.cactus.module.infra.dal.dataobject.demo.demo02.Demo02CategoryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Package: cn.cactus.module.infra.dal.mysql.demo.demo02
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/12/7 17:14
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface Demo02CategoryMapper extends BaseMapperX<Demo02CategoryDO> {

    default List<Demo02CategoryDO> selectList(Demo02CategoryListReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<Demo02CategoryDO>()
                .likeIfPresent(Demo02CategoryDO::getName, reqVO.getName())
                .eqIfPresent(Demo02CategoryDO::getParentId, reqVO.getParentId())
                .betweenIfPresent(Demo02CategoryDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(Demo02CategoryDO::getId));
    }

    default Demo02CategoryDO selectByParentIdAndName(Long parentId, String name) {
        return selectOne(Demo02CategoryDO::getParentId, parentId, Demo02CategoryDO::getName, name);
    }

    default Long selectCountByParentId(Long parentId) {
        return selectCount(Demo02CategoryDO::getParentId, parentId);
    }

}