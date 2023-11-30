package cn.cactus.module.infra.dal.mysql.job;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.cactus.module.infra.controller.admin.job.vo.job.JobExportReqVO;
import cn.cactus.module.infra.controller.admin.job.vo.job.JobPageReqVO;
import cn.cactus.module.infra.dal.dataobject.job.JobDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Package: cn.cactus.module.infra.dal.mysql.job
 * Description:
 * 定时任务 Mapper
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:55
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface JobMapper extends BaseMapperX<JobDO> {

    default JobDO selectByHandlerName(String handlerName) {
        return selectOne(JobDO::getHandlerName, handlerName);
    }

    default PageResult<JobDO> selectPage(JobPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JobDO>()
                .likeIfPresent(JobDO::getName, reqVO.getName())
                .eqIfPresent(JobDO::getStatus, reqVO.getStatus())
                .likeIfPresent(JobDO::getHandlerName, reqVO.getHandlerName())
        );
    }

    default List<JobDO> selectList(JobExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<JobDO>()
                .likeIfPresent(JobDO::getName, reqVO.getName())
                .eqIfPresent(JobDO::getStatus, reqVO.getStatus())
                .likeIfPresent(JobDO::getHandlerName, reqVO.getHandlerName())
        );
    }

}
