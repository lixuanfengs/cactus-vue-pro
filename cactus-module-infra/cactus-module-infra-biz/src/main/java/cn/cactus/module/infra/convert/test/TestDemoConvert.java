package cn.cactus.module.infra.convert.test;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.controller.admin.test.vo.TestDemoCreateReqVO;
import cn.cactus.module.infra.controller.admin.test.vo.TestDemoExcelVO;
import cn.cactus.module.infra.controller.admin.test.vo.TestDemoRespVO;
import cn.cactus.module.infra.controller.admin.test.vo.TestDemoUpdateReqVO;
import cn.cactus.module.infra.dal.dataobject.test.TestDemoDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.infra.convert.test
 * Description:
 * 字典类型 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:53
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface TestDemoConvert {

    TestDemoConvert INSTANCE = Mappers.getMapper(TestDemoConvert.class);

    TestDemoDO convert(TestDemoCreateReqVO bean);

    TestDemoDO convert(TestDemoUpdateReqVO bean);

    TestDemoRespVO convert(TestDemoDO bean);

    List<TestDemoRespVO> convertList(List<TestDemoDO> list);

    PageResult<TestDemoRespVO> convertPage(PageResult<TestDemoDO> page);

    List<TestDemoExcelVO> convertList02(List<TestDemoDO> list);

}
