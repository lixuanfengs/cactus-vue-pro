package cn.cactus.module.infra.service.config;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.controller.admin.config.vo.ConfigCreateReqVO;
import cn.cactus.module.infra.controller.admin.config.vo.ConfigExportReqVO;
import cn.cactus.module.infra.controller.admin.config.vo.ConfigPageReqVO;
import cn.cactus.module.infra.controller.admin.config.vo.ConfigUpdateReqVO;
import cn.cactus.module.infra.dal.dataobject.config.ConfigDO;

import javax.validation.Valid;
import java.util.List;

/**
 * Package: cn.cactus.module.infra.service.config
 * Description:
 * 参数配置 Service 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/28 10:21
 * @Github https://github.com/lixuanfengs
 */
public interface ConfigService {

    /**
     * 创建参数配置
     *
     * @param reqVO 创建信息
     * @return 配置编号
     */
    Long createConfig(@Valid ConfigCreateReqVO reqVO);

    /**
     * 更新参数配置
     *
     * @param reqVO 更新信息
     */
    void updateConfig(@Valid ConfigUpdateReqVO reqVO);

    /**
     * 删除参数配置
     *
     * @param id 配置编号
     */
    void deleteConfig(Long id);

    /**
     * 获得参数配置
     *
     * @param id 配置编号
     * @return 参数配置
     */
    ConfigDO getConfig(Long id);

    /**
     * 根据参数键，获得参数配置
     *
     * @param key 配置键
     * @return 参数配置
     */
    ConfigDO getConfigByKey(String key);

    /**
     * 获得参数配置分页列表
     *
     * @param reqVO 分页条件
     * @return 分页列表
     */
    PageResult<ConfigDO> getConfigPage(@Valid ConfigPageReqVO reqVO);

    /**
     * 获得参数配置列表
     *
     * @param reqVO 列表
     * @return 列表
     */
    List<ConfigDO> getConfigList(@Valid ConfigExportReqVO reqVO);


}