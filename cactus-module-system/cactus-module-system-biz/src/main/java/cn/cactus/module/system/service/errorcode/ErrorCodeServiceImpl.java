package cn.cactus.module.system.service.errorcode;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.api.errorcode.dto.ErrorCodeAutoGenerateReqDTO;
import cn.cactus.module.system.api.errorcode.dto.ErrorCodeRespDTO;
import cn.cactus.module.system.controller.admin.errorcode.vo.ErrorCodeCreateReqVO;
import cn.cactus.module.system.controller.admin.errorcode.vo.ErrorCodeExportReqVO;
import cn.cactus.module.system.controller.admin.errorcode.vo.ErrorCodePageReqVO;
import cn.cactus.module.system.controller.admin.errorcode.vo.ErrorCodeUpdateReqVO;
import cn.cactus.module.system.convert.errorcode.ErrorCodeConvert;
import cn.cactus.module.system.dal.dataobject.errorcode.ErrorCodeDO;
import cn.cactus.module.system.dal.mysql.errorcode.ErrorCodeMapper;
import cn.cactus.module.system.enums.errorcode.ErrorCodeTypeEnum;
import cn.hutool.core.collection.CollUtil;
import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static cn.cactus.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.cactus.framework.common.util.collection.CollectionUtils.convertMap;
import static cn.cactus.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.cactus.module.system.enums.ErrorCodeConstants.ERROR_CODE_DUPLICATE;
import static cn.cactus.module.system.enums.ErrorCodeConstants.ERROR_CODE_NOT_EXISTS;

/**
 * Package: cn.cactus.module.system.service.errorcode
 * Description:
 * 错误码 Service 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 15:18
 * @Github https://github.com/lixuanfengs
 */
@Service
@Validated
@Slf4j
public class ErrorCodeServiceImpl implements ErrorCodeService {

    @Resource
    private ErrorCodeMapper errorCodeMapper;

    @Override
    public Long createErrorCode(ErrorCodeCreateReqVO createReqVO) {
        // 校验 code 重复
        validateCodeDuplicate(createReqVO.getCode(), null);

        // 插入
        ErrorCodeDO errorCode = ErrorCodeConvert.INSTANCE.convert(createReqVO)
                .setType(ErrorCodeTypeEnum.MANUAL_OPERATION.getType());
        errorCodeMapper.insert(errorCode);
        // 返回
        return errorCode.getId();
    }

    @Override
    public void updateErrorCode(ErrorCodeUpdateReqVO updateReqVO) {
        // 校验存在
        validateErrorCodeExists(updateReqVO.getId());
        // 校验 code 重复
        validateCodeDuplicate(updateReqVO.getCode(), updateReqVO.getId());

        // 更新
        ErrorCodeDO updateObj = ErrorCodeConvert.INSTANCE.convert(updateReqVO)
                .setType(ErrorCodeTypeEnum.MANUAL_OPERATION.getType());
        errorCodeMapper.updateById(updateObj);
    }

    @Override
    public void deleteErrorCode(Long id) {
        // 校验存在
        validateErrorCodeExists(id);
        // 删除
        errorCodeMapper.deleteById(id);
    }

    /**
     * 校验错误码的唯一字段是否重复
     *
     * 是否存在相同编码的错误码
     *
     * @param code 错误码编码
     * @param id 错误码编号
     */
    @VisibleForTesting
    public void validateCodeDuplicate(Integer code, Long id) {
        ErrorCodeDO errorCodeDO = errorCodeMapper.selectByCode(code);
        if (errorCodeDO == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的错误码
        if (id == null) {
            throw exception(ERROR_CODE_DUPLICATE);
        }
        if (!errorCodeDO.getId().equals(id)) {
            throw exception(ERROR_CODE_DUPLICATE);
        }
    }

    @VisibleForTesting
    void validateErrorCodeExists(Long id) {
        if (errorCodeMapper.selectById(id) == null) {
            throw exception(ERROR_CODE_NOT_EXISTS);
        }
    }

    @Override
    public ErrorCodeDO getErrorCode(Long id) {
        return errorCodeMapper.selectById(id);
    }

    @Override
    public PageResult<ErrorCodeDO> getErrorCodePage(ErrorCodePageReqVO pageReqVO) {
        return errorCodeMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ErrorCodeDO> getErrorCodeList(ErrorCodeExportReqVO exportReqVO) {
        return errorCodeMapper.selectList(exportReqVO);
    }

    @Override
    @Transactional
    public void autoGenerateErrorCodes(List<ErrorCodeAutoGenerateReqDTO> autoGenerateDTOs) {
        if (CollUtil.isEmpty(autoGenerateDTOs)) {
            return;
        }
        // 获得错误码
        List<ErrorCodeDO> errorCodeDOs = errorCodeMapper.selectListByCodes(
                convertSet(autoGenerateDTOs, ErrorCodeAutoGenerateReqDTO::getCode));
        Map<Integer, ErrorCodeDO> errorCodeDOMap = convertMap(errorCodeDOs, ErrorCodeDO::getCode);

        // 遍历 autoGenerateBOs 数组，逐个插入或更新。考虑到每次量级不大，就不走批量了
        autoGenerateDTOs.forEach(autoGenerateDTO -> {
            ErrorCodeDO errorCodeDO = errorCodeDOMap.get(autoGenerateDTO.getCode());
            // 不存在，则进行新增
            if (errorCodeDO == null) {
                errorCodeDO = ErrorCodeConvert.INSTANCE.convert(autoGenerateDTO)
                        .setType(ErrorCodeTypeEnum.AUTO_GENERATION.getType());
                errorCodeMapper.insert(errorCodeDO);
                return;
            }
            // 存在，则进行更新。更新有三个前置条件：
            // 条件 1. 只更新自动生成的错误码，即 Type 为 ErrorCodeTypeEnum.AUTO_GENERATION
            if (!ErrorCodeTypeEnum.AUTO_GENERATION.getType().equals(errorCodeDO.getType())) {
                return;
            }
            // 条件 2. 分组 applicationName 必须匹配，避免存在错误码冲突的情况
            if (!autoGenerateDTO.getApplicationName().equals(errorCodeDO.getApplicationName())) {
                log.error("[autoGenerateErrorCodes][自动创建({}/{}) 错误码失败，数据库中已经存在({}/{})]",
                        autoGenerateDTO.getCode(), autoGenerateDTO.getApplicationName(),
                        errorCodeDO.getCode(), errorCodeDO.getApplicationName());
                return;
            }
            // 条件 3. 错误提示语存在差异
            if (autoGenerateDTO.getMessage().equals(errorCodeDO.getMessage())) {
                return;
            }
            // 最终匹配，进行更新
            errorCodeMapper.updateById(new ErrorCodeDO().setId(errorCodeDO.getId()).setMessage(autoGenerateDTO.getMessage()));
        });
    }

    @Override
    public List<ErrorCodeRespDTO> getErrorCodeList(String applicationName, LocalDateTime minUpdateTime) {
        List<ErrorCodeDO> errorCodeDOs = errorCodeMapper.selectListByApplicationNameAndUpdateTimeGt(
                applicationName, minUpdateTime);
        return ErrorCodeConvert.INSTANCE.convertList03(errorCodeDOs);
    }

}
