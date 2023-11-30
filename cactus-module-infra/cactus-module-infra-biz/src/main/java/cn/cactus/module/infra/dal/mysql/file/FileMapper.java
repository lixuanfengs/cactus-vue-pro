package cn.cactus.module.infra.dal.mysql.file;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.cactus.module.infra.controller.admin.file.vo.file.FilePageReqVO;
import cn.cactus.module.infra.dal.dataobject.file.FileDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Package: cn.cactus.module.infra.dal.mysql.file
 * Description:
 * 文件操作 Mapper
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:54
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface FileMapper extends BaseMapperX<FileDO> {

    default PageResult<FileDO> selectPage(FilePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FileDO>()
                .likeIfPresent(FileDO::getPath, reqVO.getPath())
                .likeIfPresent(FileDO::getType, reqVO.getType())
                .betweenIfPresent(FileDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FileDO::getId));
    }

}
