package cn.cactus.module.infra.service.test;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.controller.admin.test.vo.TestDemoCreateReqVO;
import cn.cactus.module.infra.controller.admin.test.vo.TestDemoExportReqVO;
import cn.cactus.module.infra.controller.admin.test.vo.TestDemoPageReqVO;
import cn.cactus.module.infra.controller.admin.test.vo.TestDemoUpdateReqVO;
import cn.cactus.module.infra.dal.dataobject.test.TestDemoDO;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * Package: cn.cactus.module.infra.service.test
 * Description:
 * 字典类型 Service 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/28 10:31
 * @Github https://github.com/lixuanfengs
 */
public interface TestDemoService {

    /**
     * 创建字典类型
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTestDemo(@Valid TestDemoCreateReqVO createReqVO);

    /**
     * 更新字典类型
     *
     * @param updateReqVO 更新信息
     */
    void updateTestDemo(@Valid TestDemoUpdateReqVO updateReqVO);

    /**
     * 删除字典类型
     *
     * @param id 编号
     */
    void deleteTestDemo(Long id);

    /**
     * 获得字典类型
     *
     * @param id 编号
     * @return 字典类型
     */
    TestDemoDO getTestDemo(Long id);

    /**
     * 获得字典类型列表
     *
     * @param ids 编号
     * @return 字典类型列表
     */
    List<TestDemoDO> getTestDemoList(Collection<Long> ids);

    /**
     * 获得字典类型分页
     *
     * @param pageReqVO 分页查询
     * @return 字典类型分页
     */
    PageResult<TestDemoDO> getTestDemoPage(TestDemoPageReqVO pageReqVO);

    /**
     * 获得字典类型列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 字典类型列表
     */
    List<TestDemoDO> getTestDemoList(TestDemoExportReqVO exportReqVO);

}
