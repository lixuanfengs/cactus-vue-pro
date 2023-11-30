package cn.cactus.module.infra.convert.job;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.controller.admin.job.vo.log.JobLogExcelVO;
import cn.cactus.module.infra.controller.admin.job.vo.log.JobLogRespVO;
import cn.cactus.module.infra.dal.dataobject.job.JobLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.infra.convert.job
 * Description:
 * 定时任务日志 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:51
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface JobLogConvert {

    JobLogConvert INSTANCE = Mappers.getMapper(JobLogConvert.class);

    JobLogRespVO convert(JobLogDO bean);

    List<JobLogRespVO> convertList(List<JobLogDO> list);

    PageResult<JobLogRespVO> convertPage(PageResult<JobLogDO> page);

    List<JobLogExcelVO> convertList02(List<JobLogDO> list);

}
