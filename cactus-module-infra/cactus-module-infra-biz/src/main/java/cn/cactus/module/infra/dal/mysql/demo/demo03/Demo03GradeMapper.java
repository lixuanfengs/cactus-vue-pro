package cn.cactus.module.infra.dal.mysql.demo.demo03;

import cn.cactus.framework.common.pojo.PageParam;
import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.cactus.module.infra.dal.dataobject.demo.demo03.Demo03GradeDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Package: cn.cactus.module.infra.dal.mysql.demo.demo03
 * Description:
 * 学生班级 Mapper
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/12/7 17:18
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface Demo03GradeMapper extends BaseMapperX<Demo03GradeDO> {

    default PageResult<Demo03GradeDO> selectPage(PageParam reqVO, Long studentId) {
        return selectPage(reqVO, new LambdaQueryWrapperX<Demo03GradeDO>()
                .eq(Demo03GradeDO::getStudentId, studentId)
                .orderByDesc(Demo03GradeDO::getId));
    }

    default Demo03GradeDO selectByStudentId(Long studentId) {
        return selectOne(Demo03GradeDO::getStudentId, studentId);
    }

    default int deleteByStudentId(Long studentId) {
        return delete(Demo03GradeDO::getStudentId, studentId);
    }

}
