package cn.cactus.module.infra.service.db;

import cn.cactus.module.infra.controller.admin.db.vo.DataSourceConfigCreateReqVO;
import cn.cactus.module.infra.controller.admin.db.vo.DataSourceConfigUpdateReqVO;
import cn.cactus.module.infra.dal.dataobject.db.DataSourceConfigDO;

import javax.validation.Valid;
import java.util.List;

/**
 * Package: cn.cactus.module.infra.service.db
 * Description:
 * 数据源配置 Service 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/28 10:23
 * @Github https://github.com/lixuanfengs
 */
public interface DataSourceConfigService {

    /**
     * 创建数据源配置
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createDataSourceConfig(@Valid DataSourceConfigCreateReqVO createReqVO);

    /**
     * 更新数据源配置
     *
     * @param updateReqVO 更新信息
     */
    void updateDataSourceConfig(@Valid DataSourceConfigUpdateReqVO updateReqVO);

    /**
     * 删除数据源配置
     *
     * @param id 编号
     */
    void deleteDataSourceConfig(Long id);

    /**
     * 获得数据源配置
     *
     * @param id 编号
     * @return 数据源配置
     */
    DataSourceConfigDO getDataSourceConfig(Long id);

    /**
     * 获得数据源配置列表
     *
     * @return 数据源配置列表
     */
    List<DataSourceConfigDO> getDataSourceConfigList();

}

