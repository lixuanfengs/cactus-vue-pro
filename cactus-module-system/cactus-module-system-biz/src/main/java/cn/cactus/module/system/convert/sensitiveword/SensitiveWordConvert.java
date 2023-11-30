package cn.cactus.module.system.convert.sensitiveword;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.controller.admin.sensitiveword.vo.SensitiveWordCreateReqVO;
import cn.cactus.module.system.controller.admin.sensitiveword.vo.SensitiveWordExcelVO;
import cn.cactus.module.system.controller.admin.sensitiveword.vo.SensitiveWordRespVO;
import cn.cactus.module.system.controller.admin.sensitiveword.vo.SensitiveWordUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.sensitiveword.SensitiveWordDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.sensitiveword
 * Description:
 * 敏感词 Convert
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:05
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface SensitiveWordConvert {

    SensitiveWordConvert INSTANCE = Mappers.getMapper(SensitiveWordConvert.class);

    SensitiveWordDO convert(SensitiveWordCreateReqVO bean);

    SensitiveWordDO convert(SensitiveWordUpdateReqVO bean);

    SensitiveWordRespVO convert(SensitiveWordDO bean);

    List<SensitiveWordRespVO> convertList(List<SensitiveWordDO> list);

    PageResult<SensitiveWordRespVO> convertPage(PageResult<SensitiveWordDO> page);

    List<SensitiveWordExcelVO> convertList02(List<SensitiveWordDO> list);

}
