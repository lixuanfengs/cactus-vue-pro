package cn.cactus.module.system.dal.mysql.errorcode;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.cactus.module.system.controller.admin.errorcode.vo.ErrorCodeExportReqVO;
import cn.cactus.module.system.controller.admin.errorcode.vo.ErrorCodePageReqVO;
import cn.cactus.module.system.dal.dataobject.errorcode.ErrorCodeDO;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * Package: cn.cactus.module.system.dal.mysql.errorcode
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:14
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface ErrorCodeMapper extends BaseMapperX<ErrorCodeDO> {

    default PageResult<ErrorCodeDO> selectPage(ErrorCodePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErrorCodeDO>()
                .eqIfPresent(ErrorCodeDO::getType, reqVO.getType())
                .likeIfPresent(ErrorCodeDO::getApplicationName, reqVO.getApplicationName())
                .eqIfPresent(ErrorCodeDO::getCode, reqVO.getCode())
                .likeIfPresent(ErrorCodeDO::getMessage, reqVO.getMessage())
                .betweenIfPresent(ErrorCodeDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErrorCodeDO::getCode));
    }

    default List<ErrorCodeDO> selectList(ErrorCodeExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ErrorCodeDO>()
                .eqIfPresent(ErrorCodeDO::getType, reqVO.getType())
                .likeIfPresent(ErrorCodeDO::getApplicationName, reqVO.getApplicationName())
                .eqIfPresent(ErrorCodeDO::getCode, reqVO.getCode())
                .likeIfPresent(ErrorCodeDO::getMessage, reqVO.getMessage())
                .betweenIfPresent(ErrorCodeDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ErrorCodeDO::getCode));
    }

    default List<ErrorCodeDO> selectListByCodes(Collection<Integer> codes) {
        return selectList(ErrorCodeDO::getCode, codes);
    }

    default ErrorCodeDO selectByCode(Integer code) {
        return selectOne(ErrorCodeDO::getCode, code);
    }

    default List<ErrorCodeDO> selectListByApplicationNameAndUpdateTimeGt(String applicationName, LocalDateTime minUpdateTime) {
        return selectList(new LambdaQueryWrapperX<ErrorCodeDO>().eq(ErrorCodeDO::getApplicationName, applicationName)
                .gtIfPresent(ErrorCodeDO::getUpdateTime, minUpdateTime));
    }

}