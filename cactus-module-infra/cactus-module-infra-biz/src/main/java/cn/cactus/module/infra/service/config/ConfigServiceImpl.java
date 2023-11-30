package cn.cactus.module.infra.service.config;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.infra.controller.admin.config.vo.ConfigCreateReqVO;
import cn.cactus.module.infra.controller.admin.config.vo.ConfigExportReqVO;
import cn.cactus.module.infra.controller.admin.config.vo.ConfigPageReqVO;
import cn.cactus.module.infra.controller.admin.config.vo.ConfigUpdateReqVO;
import cn.cactus.module.infra.convert.config.ConfigConvert;
import cn.cactus.module.infra.dal.dataobject.config.ConfigDO;
import cn.cactus.module.infra.dal.mysql.config.ConfigMapper;
import cn.cactus.module.infra.enums.config.ConfigTypeEnum;
import cn.hutool.core.util.StrUtil;
import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

import static cn.cactus.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.cactus.module.infra.enums.ErrorCodeConstants.*;

/**
 * Package: cn.cactus.module.infra.service.config
 * Description:
 * 参数配置 Service 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/28 10:22
 * @Github https://github.com/lixuanfengs
 */
@Service
@Slf4j
@Validated
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private ConfigMapper configMapper;

    @Override
    public Long createConfig(ConfigCreateReqVO reqVO) {
        // 校验正确性
        validateConfigForCreateOrUpdate(null, reqVO.getKey());
        // 插入参数配置
        ConfigDO config = ConfigConvert.INSTANCE.convert(reqVO);
        config.setType(ConfigTypeEnum.CUSTOM.getType());
        configMapper.insert(config);
        return config.getId();
    }

    @Override
    public void updateConfig(ConfigUpdateReqVO reqVO) {
        // 校验正确性
        validateConfigForCreateOrUpdate(reqVO.getId(), null); // 不允许更新 key
        // 更新参数配置
        ConfigDO updateObj = ConfigConvert.INSTANCE.convert(reqVO);
        configMapper.updateById(updateObj);
    }

    @Override
    public void deleteConfig(Long id) {
        // 校验配置存在
        ConfigDO config = validateConfigExists(id);
        // 内置配置，不允许删除
        if (ConfigTypeEnum.SYSTEM.getType().equals(config.getType())) {
            throw exception(CONFIG_CAN_NOT_DELETE_SYSTEM_TYPE);
        }
        // 删除
        configMapper.deleteById(id);
    }

    @Override
    public ConfigDO getConfig(Long id) {
        return configMapper.selectById(id);
    }

    @Override
    public ConfigDO getConfigByKey(String key) {
        return configMapper.selectByKey(key);
    }

    @Override
    public PageResult<ConfigDO> getConfigPage(ConfigPageReqVO reqVO) {
        return configMapper.selectPage(reqVO);
    }

    @Override
    public List<ConfigDO> getConfigList(ConfigExportReqVO reqVO) {
        return configMapper.selectList(reqVO);
    }

    private void validateConfigForCreateOrUpdate(Long id, String key) {
        // 校验自己存在
        validateConfigExists(id);
        // 校验参数配置 key 的唯一性
        if (StrUtil.isNotEmpty(key)) {
            validateConfigKeyUnique(id, key);
        }
    }

    @VisibleForTesting
    public ConfigDO validateConfigExists(Long id) {
        if (id == null) {
            return null;
        }
        ConfigDO config = configMapper.selectById(id);
        if (config == null) {
            throw exception(CONFIG_NOT_EXISTS);
        }
        return config;
    }

    @VisibleForTesting
    public void validateConfigKeyUnique(Long id, String key) {
        ConfigDO config = configMapper.selectByKey(key);
        if (config == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的参数配置
        if (id == null) {
            throw exception(CONFIG_KEY_DUPLICATE);
        }
        if (!config.getId().equals(id)) {
            throw exception(CONFIG_KEY_DUPLICATE);
        }
    }

}