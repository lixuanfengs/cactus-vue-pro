package cn.cactus.module.infra.convert.job;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.controller.admin.job.vo.job.JobCreateReqVO;
import cn.cactus.module.infra.controller.admin.job.vo.job.JobExcelVO;
import cn.cactus.module.infra.controller.admin.job.vo.job.JobRespVO;
import cn.cactus.module.infra.controller.admin.job.vo.job.JobUpdateReqVO;
import cn.cactus.module.infra.dal.dataobject.job.JobDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.infra.convert.job
 * Description:
 * 定时任务 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:51
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface JobConvert {

    JobConvert INSTANCE = Mappers.getMapper(JobConvert.class);

    JobDO convert(JobCreateReqVO bean);

    JobDO convert(JobUpdateReqVO bean);

    JobRespVO convert(JobDO bean);

    List<JobRespVO> convertList(List<JobDO> list);

    PageResult<JobRespVO> convertPage(PageResult<JobDO> page);

    List<JobExcelVO> convertList02(List<JobDO> list);

}
